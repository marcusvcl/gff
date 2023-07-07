package br.com.fiap.gff.infrastructure.adapters.output.persistence.mappers;

import br.com.fiap.gff.domain.models.Categoria;
import br.com.fiap.gff.infrastructure.adapters.output.persistence.entities.CategoriaEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CategoriaPersistenceMapper {
    Categoria toModel(CategoriaEntity entity);
    CategoriaEntity toEntity(Categoria model);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromModel(Categoria model, @MappingTarget CategoriaEntity entity);
}
