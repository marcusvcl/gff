package br.com.fiap.gff.domain.service;

import br.com.fiap.gff.application.ports.input.ProdutoUseCase;
import br.com.fiap.gff.application.ports.output.CategoriaOutputPort;
import br.com.fiap.gff.application.ports.output.ProdutoOutputPort;
import br.com.fiap.gff.domain.exceptions.RequisicaoInvalidaException;
import br.com.fiap.gff.domain.model.Categoria;
import br.com.fiap.gff.domain.model.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProdutoService implements ProdutoUseCase {

    private final ProdutoOutputPort produtoOutput;
    private final CategoriaOutputPort categoriaOutputPort;

    @Override
    public Collection<Produto> obterTodosProdutos() {
        Optional<Collection<Produto>> produtos = produtoOutput.obterTodosProdutos();
        return produtos.orElse(null);
    }

    @Override
    public Optional<Produto> obterProdutoPorId(String id) {
        return produtoOutput.obterProdutoPorId(id);
    }

    @Override
    public Collection<Produto> obterProdutoPorCategoria(Integer codigoCategoria) {
        return produtoOutput.obterProdutoPorCategoria(codigoCategoria);
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
