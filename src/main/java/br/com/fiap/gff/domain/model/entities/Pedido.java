package br.com.fiap.gff.domain.model.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import br.com.fiap.gff.domain.enums.StatusPedidoEnum;
import br.com.fiap.gff.domain.exceptions.RequisicaoInvalidaException;
import br.com.fiap.gff.domain.model.valueobjects.ClientePedido;
import br.com.fiap.gff.domain.model.valueobjects.ItemPedido;
import br.com.fiap.gff.domain.model.valueobjects.PagamentoPedido;
import br.com.fiap.gff.domain.model.valueobjects.StatusPedido;

public class Pedido {
    private String id;
    private ClientePedido cliente;
    private Collection<ItemPedido> items;
    private StatusPedido status;
    private PagamentoPedido pagamento;
    private Double totalPedido;
    private LocalDateTime dataPedido;

    public Pedido() {
    }

    public Pedido(String id, ClientePedido cliente, Collection<ItemPedido> items, StatusPedido status,
            PagamentoPedido pagamento, Double totalPedido, LocalDateTime dataPedido) {
        this.id = id;
        this.cliente = cliente;
        this.items = items;
        this.status = status;
        this.pagamento = pagamento;
        this.totalPedido = totalPedido;
        this.dataPedido = dataPedido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ClientePedido getCliente() {
        return cliente;
    }

    public void setCliente(ClientePedido cliente) {
        this.cliente = cliente;
    }

    public Collection<ItemPedido> getItems() {
        return items;
    }

    public void setItems(Collection<ItemPedido> items) {
        this.items = items;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public PagamentoPedido getPagamento() {
        return pagamento;
    }

    public void setPagamento(PagamentoPedido pagamento) {
        this.pagamento = pagamento;
    }

    public Double getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(Double totalPedido) {
        this.totalPedido = totalPedido;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public void adicionarItem(ItemPedido item) {
        if (this.items == null)
            this.items = new ArrayList<>();
        item.validateState();
        this.items.add(item);
    }

    public void adicionarItem(Collection<ItemPedido> items) {
        for (ItemPedido item : items) {
            adicionarItem(item);
        }
    }

    public void removerItem(String produtoId) {
        var item = this.items.stream().filter(i -> Objects.equals(i.getProdutoId(), produtoId)).findFirst();
        if (item.isEmpty())
            return;
        this.items.remove(item.get());
    }

    public void calcularTotalPedido() {
        if (this.items == null) {
            this.totalPedido = 0d;
            return;
        }
        this.totalPedido = items.stream().map(ItemPedido::getPreco).reduce(0d, (arg0, arg1) -> Double.sum(arg0, arg1));
    }

    public void atualizarStatus(String status) {
        if (this.status == null)
            this.status = new StatusPedido();
        StatusPedidoEnum s;
        try {
            s = StatusPedidoEnum.valueOf(status);
        } catch (IllegalArgumentException e) {
            throw new RequisicaoInvalidaException(
                    "O status informado é inválido. Por favor repita a operação com um status válido.");
        }
        this.status.setStatus(s);
    }
}
