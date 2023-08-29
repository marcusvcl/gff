package br.com.fiap.gff.infrastructure.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import br.com.fiap.gff.domain.model.entities.Cliente;
import br.com.fiap.gff.infrastructure.web.dto.request.CreateClienteRequest;
import br.com.fiap.gff.infrastructure.web.dto.request.UpdateClienteRequest;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClienteRestMapper {
    Cliente toModel(CreateClienteRequest request);
    Cliente toModel(UpdateClienteRequest request);
}
