package br.com.fiap.gff.domain.service;

import br.com.fiap.gff.application.ports.input.CategoriaUseCase;
import br.com.fiap.gff.application.ports.output.CategoriaOutputPort;
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
        return categoriaOutputPort.obterCategoriaPorId(id);
    }

    @Override
    public Categoria obterCategoriaPorCodigo(Integer codigo) {
        return categoriaOutputPort.obterCategoriaPorCodigo(codigo);
    }

    @Override
    public Categoria criarCategoria(Categoria categoria) {
        return categoriaOutputPort.salvarCategoria(categoria);
    }

    @Override
    public Categoria atualizarCategoria(Categoria categoria) {
        return categoriaOutputPort.atualizarCategoria(categoria);
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
