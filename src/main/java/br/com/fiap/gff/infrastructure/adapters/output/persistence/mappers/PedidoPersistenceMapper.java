package br.com.fiap.gff.infrastructure.adapters.output.persistence.mappers;

import br.com.fiap.gff.domain.models.Pedido;
import br.com.fiap.gff.infrastructure.adapters.output.persistence.entities.PedidoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoPersistenceMapper {

    Pedido toModel(PedidoEntity entity);
    PedidoEntity toEntity(Pedido model);

}
