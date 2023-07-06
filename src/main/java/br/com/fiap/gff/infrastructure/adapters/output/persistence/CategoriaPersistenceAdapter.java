package br.com.fiap.gff.infrastructure.adapters.output.persistence;

import br.com.fiap.gff.application.ports.output.CategoriaOutputPort;
import br.com.fiap.gff.domain.model.Categoria;
import br.com.fiap.gff.infrastructure.adapters.output.persistence.entity.CategoriaEntity;
import br.com.fiap.gff.infrastructure.adapters.output.persistence.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaPersistenceAdapter implements CategoriaOutputPort {
    private final CategoriaRepository repository;

    @Override
    public Categoria obterCategoriaPorId(String id) {
        Optional<CategoriaEntity> entity = repository.findById(id);
        return entity.map(CategoriaEntity::toDomain).orElse(null);
    }

    @Override
    public Categoria obterCategoriaPorCodigo(Integer codigo) {
        Optional<CategoriaEntity> entity = repository.findByCodigo(codigo);
        return entity.map(CategoriaEntity::toDomain).orElse(null);
    }

    @Override
    public Collection<Categoria> obterTodasCategorias() {
        List<CategoriaEntity> entities = repository.findAll();
        return entities.stream().map(CategoriaEntity::toDomain).toList();
    }

    @Override
    public Categoria atualizarCategoria(Categoria categoria) {
        Optional<CategoriaEntity> categoriaAnterior = repository.findById(categoria.getId());
        if (categoriaAnterior.isEmpty())
            return null; //TODO lançar exceção com falha na atualização do objeto
        CategoriaEntity categoriaAtualizada = categoriaAnterior.get();
        categoriaAtualizada.updateEntityFromDomain(categoria);
        repository.save(categoriaAtualizada);
        return categoria;
    }

    @Override
    public Categoria salvarCategoria(Categoria categoria) {
        return repository.insert(categoria.toEntity()).toDomain();
    }

    @Override
    public void deletarCategoriaPorCodigo(Integer codigo) {
        repository.deleteByCodigo(codigo);
    }

    @Override
    public void deletarCategoriaPorId(String id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existeCategoriaPorCodigo(Integer codigo) {
        return repository.existsCategoriaEntityByCodigo(codigo);
    }
}
