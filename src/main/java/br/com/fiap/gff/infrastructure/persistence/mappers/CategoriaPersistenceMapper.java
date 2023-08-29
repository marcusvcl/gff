package br.com.fiap.gff.infrastructure.persistence.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import br.com.fiap.gff.domain.model.entities.Categoria;
import br.com.fiap.gff.infrastructure.persistence.entities.CategoriaEntity;

@Mapper(componentModel = "spring")
public interface CategoriaPersistenceMapper {
    Categoria toModel(CategoriaEntity entity);
    CategoriaEntity toEntity(Categoria model);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromModel(Categoria model, @MappingTarget CategoriaEntity entity);
}
