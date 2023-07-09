package br.com.fiap.gff.infrastructure.adapters.input.rest.mapper;

import br.com.fiap.gff.domain.models.Cliente;
import br.com.fiap.gff.infrastructure.adapters.input.rest.data.request.CreateClienteRequest;
import br.com.fiap.gff.infrastructure.adapters.input.rest.data.request.UpdateClienteRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClienteRestMapper {
    Cliente toModel(CreateClienteRequest request);
    Cliente toModel(UpdateClienteRequest request);
}
