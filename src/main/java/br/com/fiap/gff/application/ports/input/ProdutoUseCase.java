package br.com.fiap.gff.application.ports.input;

import br.com.fiap.gff.domain.model.Produto;

import java.util.Collection;
import java.util.Optional;

public interface ProdutoUseCase {
    Collection<Produto> obterTodosProdutos();
    Optional<Produto> obterProdutoPorId(String id);
    Collection<Produto> obterProdutoPorCategoria(Integer codigoCategoria);
    Produto criarProduto(Produto produto);
    Produto atualizarProduto(Produto produto);
    void deletarProdutoPorId(String id);
}
