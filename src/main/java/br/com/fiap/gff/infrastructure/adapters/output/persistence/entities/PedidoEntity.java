package br.com.fiap.gff.infrastructure.adapters.output.persistence.entities;

import br.com.fiap.gff.domain.enums.StatusPedidoEnum;
import br.com.fiap.gff.domain.enums.TipoDePagamentoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "pedidos")
public class PedidoEntity implements Serializable {
    @Id
    private String id;
    private Cliente cliente;
    private Collection<Item> items;
    private Status status;
    private TipoDePagamentoEnum tipoPagamento;
    private Double totalPedido;
    private LocalDateTime dataPedido;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Cliente {
        private String id;
        private String nome;
        private String apelido;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Item {
        private String produtoId;
        private String nome;
        private Double preco;
        private Integer quantidade;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Status {
        private StatusPedidoEnum status;
        private String descricao;
    }
}
