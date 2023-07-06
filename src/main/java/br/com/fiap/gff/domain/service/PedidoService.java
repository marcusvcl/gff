package br.com.fiap.gff.domain.service;

import br.com.fiap.gff.application.ports.input.PedidoUseCase;
import br.com.fiap.gff.application.ports.output.PedidoOutputPort;
import br.com.fiap.gff.domain.exceptions.RecursoNaoEncontradoException;
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
        Collection<Pedido> pedidos = pedidoOutput.obterTodosPedidos();
        if (pedidos.isEmpty())
            throw new RecursoNaoEncontradoException("Nenhum pedido cadastrado no sistema.");
        return pedidos;
    }

    @Override
    public Pedido obterPedidoPorId(String id) {
        Pedido pedido = pedidoOutput.obterPedidoPorId(id);
        if (pedido == null)
            throw new RecursoNaoEncontradoException("Nenhum pedido encontrado com o id " + id + ".");
        return pedido;
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
