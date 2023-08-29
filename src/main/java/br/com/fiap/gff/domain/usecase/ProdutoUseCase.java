package br.com.fiap.gff.domain.usecase;

import java.util.Collection;

import br.com.fiap.gff.domain.model.entities.Produto;

public interface ProdutoUseCase {
    Collection<Produto> obterTodosProdutos();
    Produto obterProdutoPorId(String id);
    Collection<Produto> obterProdutoPorCategoria(Integer codigoCategoria);
    Produto criarProduto(Produto produto);
    Produto atualizarProduto(Produto produto);
    void deletarProdutoPorId(String id);
}
