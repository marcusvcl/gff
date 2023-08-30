package br.com.fiap.gff.application.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import br.com.fiap.gff.application.web.dto.request.CreateClienteRequest;
import br.com.fiap.gff.application.web.dto.request.UpdateClienteRequest;
import br.com.fiap.gff.domain.model.entities.Cliente;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClienteRestMapper {
    Cliente toModel(CreateClienteRequest request);

    Cliente toModel(UpdateClienteRequest request);
}
