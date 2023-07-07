package br.com.fiap.gff.application.ports.input;

import br.com.fiap.gff.domain.models.Pedido;

import java.util.Collection;

public interface PedidoUseCase {
    Collection<Pedido> obterTodosPedidos();
    Pedido obterPedidoPorId(String id);
    Pedido criarPedido(Pedido pedido);
    Pedido atualizarPedido(Pedido pedido);
    Pedido atualizarStatusPedido(String id, String status);
    Pedido removerItemPedido(String pedidoId, String produtoId);
    Pedido realizarCheckout(String id);
    void deletarPedidoPorId(String id);
}
