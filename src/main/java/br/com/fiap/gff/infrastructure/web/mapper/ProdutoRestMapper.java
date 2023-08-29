package br.com.fiap.gff.infrastructure.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import br.com.fiap.gff.domain.model.entities.Produto;
import br.com.fiap.gff.infrastructure.web.dto.request.CreateProdutoRequest;
import br.com.fiap.gff.infrastructure.web.dto.request.UpdateProdutoRequest;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProdutoRestMapper {
    @Mapping(target = "categoria.codigo", source = "codigoCategoria")
    Produto toModel(CreateProdutoRequest request);
    @Mapping(target = "categoria.codigo", source = "codigoCategoria")
    Produto toModel(UpdateProdutoRequest request);
}
