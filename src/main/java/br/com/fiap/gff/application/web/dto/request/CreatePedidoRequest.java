package br.com.fiap.gff.application.web.dto.request;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

import br.com.fiap.gff.domain.enums.StatusPedidoEnum;
import br.com.fiap.gff.domain.enums.TipoDePagamentoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePedidoRequest implements Serializable {
    private String clienteId;
    private String clienteApelido;
    private Collection<Item> items;
    private StatusPedidoEnum status;
    private TipoDePagamentoEnum tipoPagamento;
    private LocalDateTime dataPedido;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Item {
        private String produtoId;
        private Double precoItem;
        private Integer quantidade;
    }
}
