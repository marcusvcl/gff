package br.com.fiap.gff.infrastructure.adapters.input.rest.data.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePedidoRequest implements Serializable {

    private Collection<Item> items;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Item {
        private String produtoId;
        private Integer quantidade;
    }
}
