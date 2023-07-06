package br.com.fiap.gff.infrastructure.adapters.input.rest.mapper;

import br.com.fiap.gff.domain.model.Categoria;
import br.com.fiap.gff.infrastructure.adapters.input.rest.data.request.CategoriaCreateRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaRestMapper {
    Categoria toDomain(CategoriaCreateRequest request);
}
