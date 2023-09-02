package br.com.fiap.gff.infrastructure.persistence;

import br.com.fiap.gff.domain.gateway.ProdutoGateway;
import br.com.fiap.gff.domain.model.entities.Produto;
import br.com.fiap.gff.infrastructure.persistence.entities.ProdutoEntity;
import br.com.fiap.gff.infrastructure.persistence.mappers.ProdutoPersistenceMapper;
import br.com.fiap.gff.infrastructure.persistence.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProdutoPersistenceAdapter implements ProdutoGateway {

    private final ProdutoRepository repository;
    private final ProdutoPersistenceMapper mapper;

    @Override
    public Produto salvarProduto(Produto produto) {
        ProdutoEntity entity = mapper.toEntity(produto);
        return mapper.toModel(repository.save(entity));
    }

    @Override
    public void deletarProduto(Produto produto) {
        ProdutoEntity entity = mapper.toEntity(produto);
        repository.delete(entity);
    }

    @Override
    public void deletarProdutoPorId(String id) {
        repository.deleteById(id);
    }

    @Override
    public Produto obterProdutoPorId(String id) {
        Optional<ProdutoEntity> entity = repository.findById(id);
        return entity.map(mapper::toModel).orElse(null);
    }

    @Override
    public Collection<Produto> obterTodosProdutos() {
        List<ProdutoEntity> entities = repository.findAll();
        return entities.stream().map(mapper::toModel).toList();
    }

    @Override
    public Collection<Produto> obterProdutoPorCategoria(Integer codigoCategoria) {
        Optional<Collection<ProdutoEntity>> produtos = repository.findByCategoriaCodigo(codigoCategoria);
        return produtos
                .<Collection<Produto>>map(produtoEntities -> produtoEntities.stream().map(mapper::toModel).toList())
                .orElse(null);
    }

    @Override
    public Produto atualizarProduto(Produto produto) {
        Optional<ProdutoEntity> produtoAntigo = repository.findById(produto.getId());
        if (produtoAntigo.isEmpty())
            throw new RuntimeException("Falha ao atualizar o produto");
        produtoAntigo.ifPresent(produtoEntity -> mapper.updateEntityFromModel(produto, produtoEntity));
        var produtoAtualizado = repository.save(produtoAntigo.get());
        return mapper.toModel(produtoAtualizado);
    }
}
