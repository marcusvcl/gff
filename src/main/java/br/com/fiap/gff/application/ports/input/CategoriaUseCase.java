package br.com.fiap.gff.application.ports.input;

import br.com.fiap.gff.domain.model.Categoria;

import java.util.Collection;

public interface CategoriaUseCase {
    Collection<Categoria> obterTodasCategorias();

    Categoria obterCategoriaPorId(String id);

    Categoria obterCategoriaPorCodigo(Integer codigo);

    Categoria criarCategoria(Categoria categoria);

    Categoria atualizarCategoria(Categoria categoria);

    boolean existeCategoriaPorCodigo(Integer codigo);

    void deletarCategoriaPorId(String id);

    void deletarCategoriaPorCodigo(Integer codigo);
}
