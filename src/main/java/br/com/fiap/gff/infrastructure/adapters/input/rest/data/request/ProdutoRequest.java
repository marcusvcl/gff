package br.com.fiap.gff.infrastructure.adapters.input.rest.data.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {
    private String nome;
    private String descricao;
    private Double preco;
    private Integer estoque;
    private Integer codigoCategoria;
}
