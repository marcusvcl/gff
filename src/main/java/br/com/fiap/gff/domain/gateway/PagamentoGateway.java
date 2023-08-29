package br.com.fiap.gff.domain.gateway;

import br.com.fiap.gff.domain.model.entities.Pagamento;

public interface PagamentoGateway {
    Pagamento salvarPagamento(Pagamento pagamento);
    Pagamento obterPagamentoPeloId(String id);
    Pagamento obterPagamentoPelaTransacaoId(String transacaoId);
}
