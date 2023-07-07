package br.com.fiap.gff.infrastructure.adapters.output.httpClient.mappers;

import br.com.fiap.gff.domain.models.Pagamento;
import br.com.fiap.gff.infrastructure.adapters.output.httpClient.data.PagamentoRequest;
import br.com.fiap.gff.infrastructure.adapters.output.httpClient.data.PagamentoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PagamentoHttpMapper {
    PagamentoRequest toRequest(Pagamento pagamento);
    Pagamento toModel(PagamentoResponse response);
}
