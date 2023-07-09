package br.com.fiap.gff.infrastructure.adapters.input.rest.mapper;

import br.com.fiap.gff.domain.models.Produto;
import br.com.fiap.gff.infrastructure.adapters.input.rest.data.request.CreateProdutoRequest;
import br.com.fiap.gff.infrastructure.adapters.input.rest.data.request.UpdateProdutoRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProdutoRestMapper {
    @Mapping(target = "categoria.codigo", source = "codigoCategoria")
    Produto toModel(CreateProdutoRequest request);
    @Mapping(target = "categoria.codigo", source = "codigoCategoria")
    Produto toModel(UpdateProdutoRequest request);
}
