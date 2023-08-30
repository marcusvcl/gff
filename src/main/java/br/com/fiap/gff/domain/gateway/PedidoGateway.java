package br.com.fiap.gff.domain.gateway;

import java.util.Collection;
import br.com.fiap.gff.domain.model.entities.Pedido;

public interface PedidoGateway {

    Pedido salvarPedido(Pedido pedido);

    void deletarPedido(Pedido pedido);

    void deletarPedidoPorId(String id);

    Pedido obterPedidoPorId(String id);

    Collection<Pedido> obterTodosPedidos();

    Pedido atualizarPedido(Pedido pedido);

}
