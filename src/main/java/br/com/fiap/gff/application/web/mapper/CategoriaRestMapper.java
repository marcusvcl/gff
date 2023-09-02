package br.com.fiap.gff.application.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import br.com.fiap.gff.application.web.dto.request.CreateCategoriaRequest;
import br.com.fiap.gff.application.web.dto.request.UpdateCategoriaRequest;
import br.com.fiap.gff.domain.model.entities.Categoria;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoriaRestMapper {
    Categoria toModel(CreateCategoriaRequest request);

    Categoria toModel(UpdateCategoriaRequest request);
}
