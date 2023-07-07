package br.com.fiap.gff.application.ports.output;

import br.com.fiap.gff.domain.models.Pedido;

import java.util.Collection;

public interface PedidoOutputPort {
    Pedido salvarPedido(Pedido pedido);

    void deletarPedido(Pedido pedido);

    void deletarPedidoPorId(String id);

    Pedido obterPedidoPorId(String id);

    Collection<Pedido> obterTodosPedidos();

    Pedido atualizarPedido(Pedido pedido);
}
