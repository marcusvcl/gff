package br.com.fiap.gff.infrastructure.adapters.input.rest.mapper;

import br.com.fiap.gff.domain.models.Categoria;
import br.com.fiap.gff.infrastructure.adapters.input.rest.data.request.CreateCategoriaRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaRestMapper {
    Categoria toDomain(CreateCategoriaRequest request);
}
