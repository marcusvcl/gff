package br.com.fiap.gff.infrastructure.persistence.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import br.com.fiap.gff.domain.model.entities.Cliente;
import br.com.fiap.gff.infrastructure.persistence.entities.ClienteEntity;

@Mapper(componentModel = "spring")
public interface ClientePersistenceMapper {
    Cliente toModel(ClienteEntity entity);

    ClienteEntity toEntity(Cliente model);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromModel(Cliente model, @MappingTarget ClienteEntity entity);
}
