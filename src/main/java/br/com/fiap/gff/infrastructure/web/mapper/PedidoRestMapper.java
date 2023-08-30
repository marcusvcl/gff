package br.com.fiap.gff.infrastructure.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import br.com.fiap.gff.domain.model.entities.Pedido;
import br.com.fiap.gff.infrastructure.web.dto.request.CreatePedidoRequest;
import br.com.fiap.gff.infrastructure.web.dto.request.UpdatePedidoRequest;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PedidoRestMapper {
    @Mapping(target = "status.status", source = "status")
    @Mapping(target = "cliente.id", source = "clienteId")
    @Mapping(target = "cliente.apelido", source = "clienteApelido")
    @Mapping(target = "pagamento.tipoDePagamento", source = "tipoPagamento")
    Pedido toModel(CreatePedidoRequest request);

    Pedido toModel(UpdatePedidoRequest request);
}
