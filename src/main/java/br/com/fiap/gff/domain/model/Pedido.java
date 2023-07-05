package br.com.fiap.gff.domain.model;

import br.com.fiap.gff.domain.enums.StatusPedidoEnum;
import br.com.fiap.gff.domain.enums.TipoDePagamentoEnum;
import br.com.fiap.gff.infrastructure.adapters.output.persistence.entity.PedidoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    private String id;
    private String clienteId;
    private Collection<ItemPedido> items;
    private StatusPedidoEnum status;
    private TipoDePagamentoEnum tipoPagamento;
    private Double totalPedido;
    private LocalDate dataPedido;

    public void adicionarItem(ItemPedido item) {
        if (this.items == null)
            this.items = new ArrayList<ItemPedido>();
        items.add(item);
    }

    public PedidoEntity toEntity() {
        Collection<PedidoEntity.Item> items = new ArrayList<>();
        for (ItemPedido itemPedido : this.items) {
            PedidoEntity.Item item = new PedidoEntity.Item(itemPedido.getProdutoId(),
                    itemPedido.getPrecoItem(),
                    itemPedido.getQuantidade());
            items.add(item);
        }
        return new PedidoEntity(this.id,
                this.clienteId,
                items,
                this.status.toString(),
                this.tipoPagamento.toString(),
                this.totalPedido,
                this.dataPedido);
    }
}

