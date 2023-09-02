package br.com.fiap.gff.infrastructure.httpclient.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import br.com.fiap.gff.domain.model.entities.Pagamento;
import br.com.fiap.gff.infrastructure.httpclient.data.PagamentoRequest;
import br.com.fiap.gff.infrastructure.httpclient.data.PagamentoResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PagamentoHttpMapper {
    PagamentoRequest toRequest(Pagamento pagamento);
    Pagamento toModel(PagamentoResponse response);
}
