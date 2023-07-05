package br.com.fiap.gff.infrastructure.adapters.output.persistence.entity;

import br.com.fiap.gff.domain.enums.StatusPedidoEnum;
import br.com.fiap.gff.domain.enums.TipoDePagamentoEnum;
import br.com.fiap.gff.domain.model.ItemPedido;
import br.com.fiap.gff.domain.model.Pedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "pedidos")
public class PedidoEntity {
    @Id
    private String id;
    private String clienteId;
    private Collection<Item> items;
    private String status;
    private String tipoPagamento;
    private Double totalPedido;
    private LocalDate dataPedido;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Item {
        private String produtoId;
        private Double precoItem;
        private Integer quantidade;
    }

    public Pedido toDomain() {
        Collection<ItemPedido> items = new ArrayList<>();
        for (Item item : this.items) {
            ItemPedido itemPedido = new ItemPedido(item.getProdutoId(),
                    item.getPrecoItem(),
                    item.getQuantidade());
            items.add(itemPedido);
        }
        return new Pedido(
                this.id,
                this.clienteId,
                items,
                StatusPedidoEnum.valueOf(this.status),
                TipoDePagamentoEnum.valueOf(this.tipoPagamento),
                this.totalPedido,
                this.dataPedido);
    }

    public void updateEntityFromDomain(Pedido pedido) {
        /* Um pedido só pode ter o seus items, tipo de pagamento e status atualizados, o seu Id, o cliente
           E a data não devem ser alterados;*/
        if (pedido.getItems() != null) {
            Collection<Item> items = new ArrayList<>();
            for (ItemPedido item : pedido.getItems()) {
                Item itemPedido = new Item(item.getProdutoId(),
                        item.getPrecoItem(),
                        item.getQuantidade());
                items.add(itemPedido);
            }
            this.items = items;
        }
        if (pedido.getStatus() != null)
            this.status = pedido.getStatus().toString();
        if (pedido.getTipoPagamento() != null)
            this.tipoPagamento = pedido.getTipoPagamento().toString();
    }
}
