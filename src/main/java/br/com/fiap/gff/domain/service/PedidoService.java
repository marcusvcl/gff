package br.com.fiap.gff.domain.service;

import br.com.fiap.gff.application.ports.input.PedidoUseCase;
import br.com.fiap.gff.application.ports.output.PedidoOutputPort;
import br.com.fiap.gff.domain.model.Pedido;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PedidoService implements PedidoUseCase {

    private final PedidoOutputPort pedidoOutput;

    @Override
    public Collection<Pedido> obterTodosPedidos() {
        Optional<Collection<Pedido>> Pedidos = pedidoOutput.obterTodosPedidos();
        return Pedidos.orElse(null);
    }

    @Override
    public Optional<Pedido> obterPedidoPorId(String id) {
        return pedidoOutput.obterPedidoPorId(id);
    }

    @Override
    public Pedido criarPedido(Pedido pedido) {
        return pedidoOutput.salvarPedido(pedido);
    }

    @Override
    public Pedido atualizarPedido(Pedido pedido) {
        return pedidoOutput.atualizarPedido(pedido);
    }

    @Override
    public void deletarPedidoPorId(String id) {
        pedidoOutput.deletarPedidoPorId(id);
    }
}
