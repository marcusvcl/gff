package br.com.fiap.gff.domain.service;

import br.com.fiap.gff.application.ports.input.CategoriaUseCase;
import br.com.fiap.gff.application.ports.output.CategoriaOutputPort;
import br.com.fiap.gff.domain.exceptions.RecursoNaoEncontradoException;
import br.com.fiap.gff.domain.exceptions.RequisicaoInvalidaException;
import br.com.fiap.gff.domain.model.Categoria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class CategoriaService implements CategoriaUseCase {

    private final CategoriaOutputPort categoriaOutputPort;
    @Override
    public Collection<Categoria> obterTodasCategorias() {
        return categoriaOutputPort.obterTodasCategorias();
    }

    @Override
    public Categoria obterCategoriaPorId(String id) {
        Categoria categoria = categoriaOutputPort.obterCategoriaPorId(id);
        if (categoria == null)
            throw new RecursoNaoEncontradoException("Não foi encontrado nenhuma categoria para o id " + id);
        return categoria;
    }

    @Override
    public Categoria obterCategoriaPorCodigo(Integer codigo) {
        Categoria categoria = categoriaOutputPort.obterCategoriaPorCodigo(codigo);
        if (categoria == null)
            throw new RecursoNaoEncontradoException("Não foi encontrado nenhuma categoria para o codigo " + codigo.toString());
        return categoria;
    }

    @Override
    public Categoria criarCategoria(Categoria categoria) {
        // Verifica se já existe uma categoria com o mesmo código na base
        // Caso sim, lançar uma exceção de requisição inválida
        boolean existeCategoria = categoriaOutputPort.existeCategoriaPorCodigo(categoria.getCodigo());
        if (existeCategoria)
            throw new RequisicaoInvalidaException("Já existe uma categoria com esse código");
        Integer ultimoCodigo = categoriaOutputPort.obterUltimoCodigo();
        categoria.setCodigo(ultimoCodigo+1);
        return categoriaOutputPort.salvarCategoria(categoria);
    }

    @Override
    public Categoria atualizarCategoria(Categoria categoria) {
        return categoriaOutputPort.atualizarCategoria(categoria);
    }

    @Override
    public boolean existeCategoriaPorCodigo(Integer codigo) {
        return categoriaOutputPort.existeCategoriaPorCodigo(codigo);
    }

    @Override
    public void deletarCategoriaPorId(String id) {
        categoriaOutputPort.deletarCategoriaPorId(id);
    }

    @Override
    public void deletarCategoriaPorCodigo(Integer codigo) {
        categoriaOutputPort.deletarCategoriaPorCodigo(codigo);
    }
}
