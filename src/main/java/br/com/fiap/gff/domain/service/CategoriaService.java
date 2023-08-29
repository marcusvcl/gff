package br.com.fiap.gff.domain.service;

import br.com.fiap.gff.domain.exceptions.RecursoNaoEncontradoException;
import br.com.fiap.gff.domain.exceptions.RequisicaoInvalidaException;
import br.com.fiap.gff.domain.gateway.CategoriaGateway;
import br.com.fiap.gff.domain.model.entities.Categoria;
import br.com.fiap.gff.domain.usecase.CategoriaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class CategoriaService implements CategoriaUseCase {

    private final CategoriaGateway categoriaGateway;
    @Override
    public Collection<Categoria> obterTodasCategorias() {
        var categorias = categoriaGateway.obterTodasCategorias();
        if (categorias == null)
            throw new RecursoNaoEncontradoException("Nenhuma categoria encontrada na base.");
        return categorias;
    }

    @Override
    public Categoria obterCategoriaPorId(String id) {
        var categoria = categoriaGateway.obterCategoriaPorId(id);
        if (categoria == null)
            throw new RecursoNaoEncontradoException("Não foi encontrado nenhuma categoria para o id " + id);
        return categoria;
    }

    @Override
    public Categoria obterCategoriaPorCodigo(Integer codigo) {
        var categoria = categoriaGateway.obterCategoriaPorCodigo(codigo);
        if (categoria == null)
            throw new RecursoNaoEncontradoException("Não foi encontrado nenhuma categoria para o codigo " + codigo.toString());
        return categoria;
    }

    @Override
    public Categoria criarCategoria(Categoria categoria) {
        // Verifica se já existe uma categoria com o mesmo código na base
        // Caso sim, lançar uma exceção de requisição inválida
        boolean existeCategoria = categoriaGateway.existeCategoriaPorCodigo(categoria.getCodigo());
        if (existeCategoria)
            throw new RequisicaoInvalidaException("Já existe uma categoria com esse código");
        Integer ultimoCodigo = categoriaGateway.obterUltimoCodigo();
        categoria.setCodigo(ultimoCodigo+1);
        return categoriaGateway.salvarCategoria(categoria);
    }

    @Override
    public Categoria atualizarCategoria(Categoria categoria) {
        return categoriaGateway.atualizarCategoria(categoria);
    }

    @Override
    public boolean existeCategoriaPorCodigo(Integer codigo) {
        return categoriaGateway.existeCategoriaPorCodigo(codigo);
    }

    @Override
    public void deletarCategoriaPorId(String id) {
        categoriaGateway.deletarCategoriaPorId(id);
    }

    @Override
    public void deletarCategoriaPorCodigo(Integer codigo) {
        categoriaGateway.deletarCategoriaPorCodigo(codigo);
    }
}
