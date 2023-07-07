package br.com.fiap.gff.application.ports.input;

import br.com.fiap.gff.domain.models.Produto;

import java.util.Collection;

public interface ProdutoUseCase {
    Collection<Produto> obterTodosProdutos();
    Produto obterProdutoPorId(String id);
    Collection<Produto> obterProdutoPorCategoria(Integer codigoCategoria);
    Produto criarProduto(Produto produto);
    Produto atualizarProduto(Produto produto);
    void deletarProdutoPorId(String id);
}
