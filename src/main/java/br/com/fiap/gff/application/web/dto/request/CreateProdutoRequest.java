package br.com.fiap.gff.application.web.dto.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
