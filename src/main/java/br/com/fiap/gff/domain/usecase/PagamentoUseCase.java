package br.com.fiap.gff.domain.usecase;

import br.com.fiap.gff.domain.model.entities.Pedido;

public interface PagamentoUseCase {
    Pedido executarPagamento(Pedido pedido);
}
