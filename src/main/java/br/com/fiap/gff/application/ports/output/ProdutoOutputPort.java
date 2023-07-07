package br.com.fiap.gff.application.ports.output;

import br.com.fiap.gff.domain.models.Produto;

import java.util.Collection;

public interface ProdutoOutputPort {
    Produto salvarProduto(Produto produto);

    void deletarProduto(Produto produto);

    void deletarProdutoPorId(String id);

    Produto obterProdutoPorId(String id);

    Collection<Produto> obterTodosProdutos();

    Collection<Produto> obterProdutoPorCategoria(Integer codigoCategoria);

    Produto atualizarProduto(Produto produto);
}
