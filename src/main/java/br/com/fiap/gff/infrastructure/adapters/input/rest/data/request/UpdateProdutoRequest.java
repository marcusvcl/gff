package br.com.fiap.gff.infrastructure.adapters.input.rest.data.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProdutoRequest implements Serializable {
    private String descricao;
    private Double preco;
    private Integer estoque;
    private Integer codigoCategoria;
}
