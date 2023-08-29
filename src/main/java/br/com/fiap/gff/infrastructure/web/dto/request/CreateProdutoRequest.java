package br.com.fiap.gff.infrastructure.web.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProdutoRequest implements Serializable {
    private String nome;
    private String descricao;
    private Double preco;
    private Integer estoque;
    private Integer codigoCategoria;
}
