package br.com.fiap.gff.infrastructure.persistence.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.fiap.gff.domain.enums.StatusPagamentoEnum;
import br.com.fiap.gff.domain.enums.StatusPedidoEnum;
import br.com.fiap.gff.domain.enums.TipoDePagamentoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Pagamento pagamento;
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

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Pagamento {
        private TipoDePagamentoEnum tipoDePagamento;
        private String transacaoId;
        private double valorPago;
        private StatusPagamentoEnum status;
    }
}
