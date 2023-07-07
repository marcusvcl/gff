package br.com.fiap.gff.application.ports.input;

import br.com.fiap.gff.domain.models.Pagamento;
import br.com.fiap.gff.domain.models.Pedido;

public interface PagamentoUseCase {
    Pedido executarPagamento(Pedido pedido);
}
