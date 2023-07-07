package br.com.fiap.gff.application.ports.output;

import br.com.fiap.gff.domain.models.Pagamento;

public interface PagamentoOutputPort {
    Pagamento salvarPagamento(Pagamento pagamento);
    Pagamento obterPagamentoPeloId(String id);
    Pagamento obterPagamentoPelaTransacaoId(String transacaoId);
}
