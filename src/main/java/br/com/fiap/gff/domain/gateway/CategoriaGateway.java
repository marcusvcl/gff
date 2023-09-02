package br.com.fiap.gff.domain.gateway;

import java.util.Collection;

import br.com.fiap.gff.domain.model.entities.Categoria;

public interface CategoriaGateway {
    Categoria obterCategoriaPorId(String id);

    Categoria obterCategoriaPorCodigo(Integer codigo);

    Collection<Categoria> obterTodasCategorias();

    Integer obterUltimoCodigo();

    Categoria atualizarCategoria(Categoria categoria);

    Categoria salvarCategoria(Categoria categoria);

    void deletarCategoriaPorCodigo(Integer codigo);

    void deletarCategoriaPorId(String id);

    boolean existeCategoriaPorCodigo(Integer codigo);
}
