package br.com.fiap.gff.application.ports.output;

import br.com.fiap.gff.domain.model.Categoria;

import java.util.Collection;

public interface CategoriaOutputPort {
    Categoria obterCategoriaPorId(String id);
    Categoria obterCategoriaPorCodigo(Integer codigo);
    Collection<Categoria> obterTodasCategorias();
    Categoria atualizarCategoria(Categoria categoria);
    Categoria salvarCategoria(Categoria categoria);
    void deletarCategoriaPorCodigo(Integer codigo);
    void deletarCategoriaPorId(String id);
    boolean existeCategoriaPorCodigo(Integer codigo);
}
