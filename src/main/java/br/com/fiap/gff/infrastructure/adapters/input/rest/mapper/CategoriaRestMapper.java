package br.com.fiap.gff.infrastructure.adapters.input.rest.mapper;

import br.com.fiap.gff.domain.models.Categoria;
import br.com.fiap.gff.infrastructure.adapters.input.rest.data.request.CreateCategoriaRequest;
import br.com.fiap.gff.infrastructure.adapters.input.rest.data.request.UpdateCategoriaRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoriaRestMapper {
    Categoria toModel(CreateCategoriaRequest request);
    Categoria toModel(UpdateCategoriaRequest request);
}
