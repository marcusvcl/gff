package br.com.fiap.gff.domain.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import br.com.fiap.gff.domain.exceptions.RecursoNaoEncontradoException;
import br.com.fiap.gff.domain.exceptions.RequisicaoInvalidaException;
import br.com.fiap.gff.domain.gateway.ProdutoGateway;
import br.com.fiap.gff.domain.model.entities.Produto;
import br.com.fiap.gff.domain.usecase.CategoriaUseCase;
import br.com.fiap.gff.domain.usecase.ProdutoUseCase;

@Service
public class ProdutoService implements ProdutoUseCase {

    private final ProdutoGateway gateway;
    private final CategoriaUseCase categoriaUseCase;

    public ProdutoService(ProdutoGateway gateway, CategoriaUseCase categoriaUseCase) {
        this.gateway = gateway;
        this.categoriaUseCase = categoriaUseCase;
    }

    @Override
    public Collection<Produto> obterTodosProdutos() {
        var produtos = gateway.obterTodosProdutos();
        if (produtos.isEmpty())
            throw new RecursoNaoEncontradoException("Não foram encontrados produtos cadatrados no sistema.");
        return produtos;
    }

    @Override
    public Produto obterProdutoPorId(String id) {
        var produto = gateway.obterProdutoPorId(id);
        if (produto == null)
            throw new RecursoNaoEncontradoException("Não foi encontrado nenhum produto para o id " + id + ".");
        return produto;
    }

    @Override
    public Collection<Produto> obterProdutoPorCategoria(Integer codigoCategoria) {
        var produtos = gateway.obterProdutoPorCategoria(codigoCategoria);
        if (produtos.isEmpty())
            throw new RecursoNaoEncontradoException(
                    "Não foram encontrados nenhum produto para a categoria " + codigoCategoria + " informada.");
        return produtos;
    }

    @Override
    public Produto criarProduto(Produto produto) {
        // Recupera a categoria pelo código informado, se existir a categoria será
        // vinculada ao produto
        // se não, será lançado uma execeção de negócio.
        var categoria = categoriaUseCase.obterCategoriaPorCodigo(produto.getCategoria().getCodigo());
        if (categoria == null)
            throw new RequisicaoInvalidaException("Não existe a categoria informada no produto!");
        produto.setCategoria(categoria);
        return gateway.salvarProduto(produto);
    }

    @Override
    public Produto atualizarProduto(Produto produto) {
        return gateway.atualizarProduto(produto);
    }

    @Override
    public void deletarProdutoPorId(String id) {
        gateway.deletarProdutoPorId(id);
    }
}
