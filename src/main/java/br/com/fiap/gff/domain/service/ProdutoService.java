package br.com.fiap.gff.domain.service;

import br.com.fiap.gff.application.ports.input.ProdutoUseCase;
import br.com.fiap.gff.application.ports.output.CategoriaOutputPort;
import br.com.fiap.gff.application.ports.output.ProdutoOutputPort;
import br.com.fiap.gff.domain.exceptions.RecursoNaoEncontradoException;
import br.com.fiap.gff.domain.exceptions.RequisicaoInvalidaException;
import br.com.fiap.gff.domain.model.Categoria;
import br.com.fiap.gff.domain.model.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class ProdutoService implements ProdutoUseCase {

    private final ProdutoOutputPort produtoOutput;
    private final CategoriaOutputPort categoriaOutputPort;

    @Override
    public Collection<Produto> obterTodosProdutos() {
        Collection<Produto> produtos = produtoOutput.obterTodosProdutos();
        if (produtos.isEmpty())
            throw new RecursoNaoEncontradoException("Não foram encontrados produtos cadatrados no sistema.");
        return produtos;
    }

    @Override
    public Produto obterProdutoPorId(String id) {
        Produto produto = produtoOutput.obterProdutoPorId(id);
        if (produto == null)
            throw new RecursoNaoEncontradoException("Não foi encontrado nenhum produto para o id " + id + ".");
        return produto;
    }

    @Override
    public Collection<Produto> obterProdutoPorCategoria(Integer codigoCategoria) {
        Collection<Produto> produtos = produtoOutput.obterProdutoPorCategoria(codigoCategoria);
        if (produtos.isEmpty())
            throw new RecursoNaoEncontradoException("Não foram encontrados nenhum produto para a categoria " + codigoCategoria + " informada.");
        return produtos;
    }

    @Override
    public Produto criarProduto(Produto produto) {
        // Recupera a categoria pelo código informado, se existir a categoria será vinculada ao produto
        // se não, será lançado uma execeção de negócio.
        Categoria categoria = categoriaOutputPort.obterCategoriaPorCodigo(produto.getCategoria().getCodigo());
        if (categoria == null)
            throw new RequisicaoInvalidaException("Não existe a categoria informada no produto!");
        produto.setCategoria(categoria);
        return produtoOutput.salvarProduto(produto);
    }

    @Override
    public Produto atualizarProduto(Produto produto) {
        return produtoOutput.atualizarProduto(produto);
    }

    @Override
    public void deletarProdutoPorId(String id) {
        produtoOutput.deletarProdutoPorId(id);
    }
}
