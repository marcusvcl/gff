package br.com.fiap.gff.domain.usecase;

import java.util.Collection;

import br.com.fiap.gff.domain.enums.StatusPagamentoEnum;
import br.com.fiap.gff.domain.model.entities.Pedido;

public interface PedidoUseCase {

    Collection<Pedido> obterTodosPedidos();

    Pedido obterPedidoPorId(String id);

    StatusPagamentoEnum obterStatusDoPagamento(String id);

    Pedido criarPedido(Pedido pedido);

    Pedido atualizarPedido(Pedido pedido);

    Pedido atualizarStatusPedido(String id, String status);

    Pedido removerItemPedido(String pedidoId, String produtoId);

    Pedido realizarCheckout(String id);

    void deletarPedidoPorId(String id);
}
