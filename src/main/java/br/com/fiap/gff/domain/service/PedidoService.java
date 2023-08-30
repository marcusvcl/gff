package br.com.fiap.gff.domain.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import br.com.fiap.gff.domain.exceptions.RecursoNaoEncontradoException;
import br.com.fiap.gff.domain.exceptions.RequisicaoInvalidaException;
import br.com.fiap.gff.domain.gateway.PedidoGateway;
import br.com.fiap.gff.domain.model.entities.Cliente;
import br.com.fiap.gff.domain.model.entities.Pedido;
import br.com.fiap.gff.domain.model.valueobjects.ClientePedido;
import br.com.fiap.gff.domain.model.valueobjects.ItemPedido;
import br.com.fiap.gff.domain.usecase.ClienteUseCase;
import br.com.fiap.gff.domain.usecase.PagamentoUseCase;
import br.com.fiap.gff.domain.usecase.PedidoUseCase;
import br.com.fiap.gff.domain.usecase.ProdutoUseCase;

@Service
public class PedidoService implements PedidoUseCase {

    private final PedidoGateway gateway;
    private final ProdutoUseCase produtoUseCase;
    private final ClienteUseCase clienteUseCase;
    private final PagamentoUseCase pagamentoUseCase;

    public PedidoService(PedidoGateway gateway, ProdutoUseCase produtoUseCase, ClienteUseCase clienteUseCase,
            PagamentoUseCase pagamentoUseCase) {
        this.gateway = gateway;
        this.produtoUseCase = produtoUseCase;
        this.clienteUseCase = clienteUseCase;
        this.pagamentoUseCase = pagamentoUseCase;
    }

    @Override
    public Collection<Pedido> obterTodosPedidos() {
        Collection<Pedido> pedidos = gateway.obterTodosPedidos();
        if (pedidos.isEmpty())
            throw new RecursoNaoEncontradoException("Nenhum pedido cadastrado no sistema.");
        return pedidos;
    }

    @Override
    public Pedido obterPedidoPorId(String id) {
        Pedido pedido = gateway.obterPedidoPorId(id);
        if (pedido == null)
            throw new RecursoNaoEncontradoException("Nenhum pedido encontrado com o id " + id + ".");
        return pedido;
    }

    @Override
    public Pedido criarPedido(Pedido pedido) {
        validarClienteDoPedido(pedido.getCliente());
        validarProdutosDoPedido(pedido.getItems());
        pedido.calcularTotalPedido();
        return gateway.salvarPedido(pedido);
    }

    @Override
    public Pedido atualizarPedido(Pedido pedido) {
        var pedidoAnterior = obterPedidoPorId(pedido.getId());
        validarProdutosDoPedido(pedido.getItems());
        pedidoAnterior.adicionarItem(pedido.getItems());
        pedidoAnterior.calcularTotalPedido();
        return gateway.atualizarPedido(pedidoAnterior);
    }

    @Override
    public Pedido atualizarStatusPedido(String id, String status) {
        var pedidoAnterior = obterPedidoPorId(id);
        pedidoAnterior.atualizarStatus(status);
        return gateway.atualizarPedido(pedidoAnterior);
    }

    @Override
    public Pedido removerItemPedido(String pedidoId, String produtoId) {
        var pedidoAnterior = obterPedidoPorId(pedidoId);
        pedidoAnterior.removerItem(produtoId);
        pedidoAnterior.calcularTotalPedido();
        return gateway.atualizarPedido(pedidoAnterior);
    }

    @Override
    public Pedido realizarCheckout(String id) {
        var pedido = obterPedidoPorId(id);
        pedido = pagamentoUseCase.executarPagamento(pedido);
        return gateway.atualizarPedido(pedido);
    }

    @Override
    public void deletarPedidoPorId(String id) {
        gateway.deletarPedidoPorId(id);
    }

    private void validarProdutosDoPedido(Collection<ItemPedido> items) {
        if (items == null)
            return;
        for (ItemPedido item : items) {
            var produto = produtoUseCase.obterProdutoPorId(item.getProdutoId());
            if (produto == null)
                throw new RequisicaoInvalidaException("Pedido com produto inválido. Por favor repita a operação.");
            if (produto.getEstoque() < item.getQuantidade())
                throw new RequisicaoInvalidaException(
                        "Erro ao atualizar o pedido. Item sem estoque. Por favor repita a operação.");
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
        var cliente = clienteUseCase.obterClientePorId(id);
        if (cliente == null)
            throw new RecursoNaoEncontradoException("Cliente não encontrado na base.");
        return cliente;
    }

}
