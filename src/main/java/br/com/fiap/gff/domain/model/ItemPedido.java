package br.com.fiap.gff.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedido {
    private String produtoId;
    private Double precoItem;
    private Integer quantidade;
}
