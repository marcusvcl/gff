package br.com.fiap.gff.application.ports.input;

import br.com.fiap.gff.domain.model.Pedido;

import java.util.Collection;
import java.util.Optional;

public interface PedidoUseCase {
    Collection<Pedido> obterTodosPedidos();
    Pedido obterPedidoPorId(String id);
    Pedido criarPedido(Pedido pedido);
    Pedido atualizarPedido(Pedido pedido);
    void deletarPedidoPorId(String id);
}
