package br.com.fiap.gff.infrastructure.adapters.output.persistence.mappers;

import br.com.fiap.gff.domain.models.Cliente;
import br.com.fiap.gff.infrastructure.adapters.output.persistence.entities.ClienteEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ClientePersistenceMapper {
    Cliente toModel(ClienteEntity entity);
    ClienteEntity toEntity(Cliente model);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromModel(Cliente model, @MappingTarget ClienteEntity entity);
}
