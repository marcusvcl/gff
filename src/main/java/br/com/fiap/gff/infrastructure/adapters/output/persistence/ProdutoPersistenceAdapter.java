package br.com.fiap.gff.infrastructure.adapters.output.persistence;

import br.com.fiap.gff.application.ports.output.ProdutoOutputPort;
import br.com.fiap.gff.domain.model.Produto;
import br.com.fiap.gff.infrastructure.adapters.output.persistence.entity.ProdutoEntity;
import br.com.fiap.gff.infrastructure.adapters.output.persistence.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProdutoPersistenceAdapter implements ProdutoOutputPort {

    private final ProdutoRepository repository;

    @Override
    public Produto salvarProduto(Produto produto) {
        ProdutoEntity entity = produto.toEntity();
        return repository.save(entity).toDomain();
    }

    @Override
    public void deletarProduto(Produto produto) {
        ProdutoEntity entity = produto.toEntity();
        repository.delete(entity);
    }

    @Override
    public void deletarProdutoPorId(String id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Produto> obterProdutoPorId(String id) {
        Optional<ProdutoEntity> entity = repository.findById(id);
        return entity.map(ProdutoEntity::toDomain);
    }

    @Override
    public Optional<Collection<Produto>> obterTodosProdutos() {
        List<ProdutoEntity> entities = repository.findAll();
        return Optional.of(entities.stream().map(ProdutoEntity::toDomain).toList());
    }

    @Override
    public Collection<Produto> obterProdutoPorCategoria(Integer codigoCategoria) {
        Optional<Collection<ProdutoEntity>> produtos = repository.findByCategoriaCodigo(codigoCategoria);
        return produtos.<Collection<Produto>>map(produtoEntities ->
                produtoEntities.stream().map(ProdutoEntity::toDomain).toList()).orElse(null);
    }

    @Override
    public Produto atualizarProduto(Produto produto) {
        Optional<ProdutoEntity> produtoAntigo = repository.findById(produto.getId());
        if (produtoAntigo.isEmpty())
            throw new RuntimeException("Falha ao atualizar o produto");
        produtoAntigo.ifPresent(produtoEntity -> produtoEntity.updateEntityFromDomain(produto));
        return produtoAntigo.get().toDomain();
    }
}
