package br.com.fiap.gff.infrastructure.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import br.com.fiap.gff.domain.gateway.CategoriaGateway;
import br.com.fiap.gff.domain.model.entities.Categoria;
import br.com.fiap.gff.infrastructure.persistence.entities.CategoriaEntity;
import br.com.fiap.gff.infrastructure.persistence.mappers.CategoriaPersistenceMapper;
import br.com.fiap.gff.infrastructure.persistence.repositories.CategoriaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaGatewayImpl implements CategoriaGateway {

    private final CategoriaRepository repository;
    private final CategoriaPersistenceMapper mapper;

    @Override
    public Categoria obterCategoriaPorId(String id) {
        Optional<CategoriaEntity> entity = repository.findById(id);
        return entity.map(mapper::toModel).orElse(null);
    }

    @Override
    public Categoria obterCategoriaPorCodigo(Integer codigo) {
        Optional<CategoriaEntity> entity = repository.findByCodigo(codigo);
        return entity.map(mapper::toModel).orElse(null);
    }

    @Override
    public Collection<Categoria> obterTodasCategorias() {
        List<CategoriaEntity> entities = repository.findAll();
        return entities.stream().map(mapper::toModel).toList();
    }

    @Override
    public Integer obterUltimoCodigo() {
        Optional<CategoriaEntity> categoria = repository.findFirstByOrderByCodigoDesc();
        if (categoria.isEmpty())
            return 0;
        return categoria.get().getCodigo();
    }

    @Override
    public Categoria atualizarCategoria(Categoria categoria) {
        Optional<CategoriaEntity> categoriaAnterior = repository.findById(categoria.getId());
        if (categoriaAnterior.isEmpty())
            return null; 
        CategoriaEntity categoriaAtualizada = categoriaAnterior.get();
        mapper.updateEntityFromModel(categoria, categoriaAtualizada);
        repository.save(categoriaAtualizada);
        return categoria;
    }

    @Override
    public Categoria salvarCategoria(Categoria categoria) {
        return mapper.toModel(repository.insert(mapper.toEntity(categoria)));
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
