package br.com.fiap.gff.infrastructure.persistence.mappers;

import org.mapstruct.Mapper;

import br.com.fiap.gff.domain.model.entities.Pedido;
import br.com.fiap.gff.infrastructure.persistence.entities.PedidoEntity;

@Mapper(componentModel = "spring")
public interface PedidoPersistenceMapper {

    Pedido toModel(PedidoEntity entity);

    PedidoEntity toEntity(Pedido model);

}
