package br.com.fiap.gff.infrastructure.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import br.com.fiap.gff.domain.model.entities.Categoria;
import br.com.fiap.gff.infrastructure.web.dto.request.CreateCategoriaRequest;
import br.com.fiap.gff.infrastructure.web.dto.request.UpdateCategoriaRequest;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoriaRestMapper {
    Categoria toModel(CreateCategoriaRequest request);
    Categoria toModel(UpdateCategoriaRequest request);
}
