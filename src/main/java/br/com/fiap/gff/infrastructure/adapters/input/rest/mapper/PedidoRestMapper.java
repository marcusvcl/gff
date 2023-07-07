package br.com.fiap.gff.infrastructure.adapters.input.rest.mapper;

import br.com.fiap.gff.domain.models.Pedido;
import br.com.fiap.gff.infrastructure.adapters.input.rest.data.request.CreatePedidoRequest;
import br.com.fiap.gff.infrastructure.adapters.input.rest.data.request.UpdatePedidoRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PedidoRestMapper {
    @Mapping(target = "status.status", source = "status")
    @Mapping(target = "cliente.id", source = "clienteId")
    @Mapping(target = "cliente.apelido", source = "clienteApelido")
    @Mapping(target = "pagamento.tipoDePagamento", source = "tipoPagamento")
    Pedido toModel(CreatePedidoRequest request);
    Pedido toModel(UpdatePedidoRequest request);
}
