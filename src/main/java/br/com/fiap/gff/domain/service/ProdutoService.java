package br.com.fiap.gff.domain.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import br.com.fiap.gff.domain.exceptions.RecursoNaoEncontradoException;
import br.com.fiap.gff.domain.exceptions.RequisicaoInvalidaException;
import br.com.fiap.gff.domain.gateway.CategoriaGateway;
import br.com.fiap.gff.domain.gateway.ProdutoGateway;
import br.com.fiap.gff.domain.model.entities.Produto;
import br.com.fiap.gff.domain.usecase.ProdutoUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProdutoService implements ProdutoUseCase {

    private final ProdutoGateway produtoGateway;
    private final CategoriaGateway categoriaGateway;

    @Override
    public Collection<Produto> obterTodosProdutos() {
        var produtos = produtoGateway.obterTodosProdutos();
        if (produtos.isEmpty())
            throw new RecursoNaoEncontradoException("Não foram encontrados produtos cadatrados no sistema.");
        return produtos;
    }

    @Override
    public Produto obterProdutoPorId(String id) {
        var produto = produtoGateway.obterProdutoPorId(id);
        if (produto == null)
            throw new RecursoNaoEncontradoException("Não foi encontrado nenhum produto para o id " + id + ".");
        return produto;
    }

    @Override
    public Collection<Produto> obterProdutoPorCategoria(Integer codigoCategoria) {
        var produtos = produtoGateway.obterProdutoPorCategoria(codigoCategoria);
        if (produtos.isEmpty())
            throw new RecursoNaoEncontradoException("Não foram encontrados nenhum produto para a categoria " + codigoCategoria + " informada.");
        return produtos;
    }

    @Override
    public Produto criarProduto(Produto produto) {
        // Recupera a categoria pelo código informado, se existir a categoria será vinculada ao produto
        // se não, será lançado uma execeção de negócio.
        var categoria = categoriaGateway.obterCategoriaPorCodigo(produto.getCategoria().getCodigo());
        if (categoria == null)
            throw new RequisicaoInvalidaException("Não existe a categoria informada no produto!");
        produto.setCategoria(categoria);
        return produtoGateway.salvarProduto(produto);
    }

    @Override
    public Produto atualizarProduto(Produto produto) {
        return produtoGateway.atualizarProduto(produto);
    }

    @Override
    public void deletarProdutoPorId(String id) {
        produtoGateway.deletarProdutoPorId(id);
    }
}
