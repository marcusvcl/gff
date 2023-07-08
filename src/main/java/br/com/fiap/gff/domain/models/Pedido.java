package br.com.fiap.gff.domain.models;

import br.com.fiap.gff.domain.enums.StatusPedidoEnum;
import br.com.fiap.gff.domain.exceptions.RequisicaoInvalidaException;
import br.com.fiap.gff.domain.valueObjects.ClientePedido;
import br.com.fiap.gff.domain.valueObjects.ItemPedido;
import br.com.fiap.gff.domain.valueObjects.PagamentoPedido;
import br.com.fiap.gff.domain.valueObjects.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    private String id;
    private ClientePedido cliente;
    private Collection<ItemPedido> items;
    private StatusPedido status;
    private PagamentoPedido pagamento;
    private Double totalPedido;
    private LocalDateTime dataPedido;

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
        this.totalPedido = items.stream().map(ItemPedido::getPreco).reduce(0d, Double::sum);
    }

    public void atualizarStatus(String status) {
        if (this.status == null)
            this.status = new StatusPedido();
        StatusPedidoEnum s;
        try {
            s = StatusPedidoEnum.valueOf(status);
        } catch (IllegalArgumentException e) {
            throw new RequisicaoInvalidaException("O status informado é inválido. Por favor repita a operação com um status válido.");
        }
        this.status.setStatus(s);
    }
}

