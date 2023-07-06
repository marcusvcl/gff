package br.com.fiap.gff.infrastructure.adapters.input.rest.mapper;

import br.com.fiap.gff.domain.model.Produto;
import br.com.fiap.gff.infrastructure.adapters.input.rest.data.request.ProdutoRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProdutoRestMapper {
    @Mapping(target = "categoria.codigo", source = "codigoCategoria")
    Produto toDomain(ProdutoRequest request);
}
