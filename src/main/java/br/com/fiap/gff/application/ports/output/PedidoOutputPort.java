package br.com.fiap.gff.application.ports.output;

import br.com.fiap.gff.domain.model.Pedido;

import java.util.Collection;
import java.util.Optional;

public interface PedidoOutputPort {
    Pedido salvarPedido(Pedido pedido);

    void deletarPedido(Pedido pedido);

    void deletarPedidoPorId(String id);

    Pedido obterPedidoPorId(String id);

    Collection<Pedido> obterTodosPedidos();

    Pedido atualizarPedido(Pedido pedido);
}
