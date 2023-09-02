package br.com.fiap.gff.domain.gateway;

import java.util.Collection;

import br.com.fiap.gff.domain.model.entities.Produto;

public interface ProdutoGateway {
    Produto salvarProduto(Produto produto);

    void deletarProduto(Produto produto);

    void deletarProdutoPorId(String id);

    Produto obterProdutoPorId(String id);

    Collection<Produto> obterTodosProdutos();

    Collection<Produto> obterProdutoPorCategoria(Integer codigoCategoria);

    Produto atualizarProduto(Produto produto);
}
