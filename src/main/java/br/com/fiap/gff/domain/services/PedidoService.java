package br.com.fiap.gff.domain.services;

import br.com.fiap.gff.application.ports.input.PagamentoUseCase;
import br.com.fiap.gff.application.ports.input.PedidoUseCase;
import br.com.fiap.gff.application.ports.output.ClienteOutputPort;
import br.com.fiap.gff.application.ports.output.PedidoOutputPort;
import br.com.fiap.gff.application.ports.output.ProdutoOutputPort;
import br.com.fiap.gff.domain.exceptions.RecursoNaoEncontradoException;
import br.com.fiap.gff.domain.exceptions.RequisicaoInvalidaException;
import br.com.fiap.gff.domain.models.Cliente;
import br.com.fiap.gff.domain.models.Pedido;
import br.com.fiap.gff.domain.models.Produto;
import br.com.fiap.gff.domain.valueObjects.ClientePedido;
import br.com.fiap.gff.domain.valueObjects.ItemPedido;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class PedidoService implements PedidoUseCase {

    private final PedidoOutputPort pedidoOutput;
    private final ProdutoOutputPort produtoOutputPort;
    private final ClienteOutputPort clienteOutputPort;
    private final PagamentoUseCase pagamentoUseCase;

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
        validarClienteDoPedido(pedido.getCliente());
        validarProdutosDoPedido(pedido.getItems());
        pedido.calcularTotalPedido();
        return pedidoOutput.salvarPedido(pedido);
    }

    @Override
    public Pedido atualizarPedido(Pedido pedido) {
        var pedidoAnterior =  obterPedidoPorId(pedido.getId());
        validarProdutosDoPedido(pedido.getItems());
        pedidoAnterior.adicionarItem(pedido.getItems());
        pedidoAnterior.calcularTotalPedido();
        return pedidoOutput.atualizarPedido(pedidoAnterior);
    }

    @Override
    public Pedido removerItemPedido(String pedidoId, String produtoId) {
        var pedidoAnterior = obterPedidoPorId(pedidoId);
        pedidoAnterior.removerItem(produtoId);
        pedidoAnterior.calcularTotalPedido();
        return pedidoOutput.atualizarPedido(pedidoAnterior);
    }

    @Override
    public Pedido realizarCheckout(String id) {
        var pedido = obterPedidoPorId(id);
        return pagamentoUseCase.executarPagamento(pedido);
    }

    @Override
    public void deletarPedidoPorId(String id) {
        pedidoOutput.deletarPedidoPorId(id);
    }

    private void validarProdutosDoPedido(Collection<ItemPedido> items) {
        if (items == null)
            return;
        for (ItemPedido item : items) {
            var produto = produtoOutputPort.obterProdutoPorId(item.getProdutoId());
            if (produto == null)
                throw new RequisicaoInvalidaException("Pedido com produto inválido. Por favor repita a operação.");
            if (produto.getEstoque() < item.getQuantidade())
                throw new RequisicaoInvalidaException("Erro ao atualizar o pedido. Item sem estoque. Por favor repita a operação.");
            item.setPreco(produto.getPreco());
            item.setNome(produto.getNome());
        }
    }

    private void validarClienteDoPedido(ClientePedido cliente) {
        if (cliente == null)
            throw new RequisicaoInvalidaException("Deve ser informado um cliente para continuar o pedido.");
        if (cliente.getId() != null) {
            Cliente c = recuperarInformacaoCliente(cliente.getId());
            cliente.setApelido(c.getApelido());
            cliente.setNome(c.getNome());
        } else if (cliente.getApelido() == null) {
            throw new RequisicaoInvalidaException("Deve ser informado um nome para o cliente do pedido.");
        }
    }

    private Cliente recuperarInformacaoCliente(String id) {
        var cliente = clienteOutputPort.obterClientePorId(id);
        if (cliente == null)
            throw new RecursoNaoEncontradoException("Cliente não encontrado na base.");
        return cliente;
    }

}
