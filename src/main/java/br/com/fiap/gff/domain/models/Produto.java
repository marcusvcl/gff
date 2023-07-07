package br.com.fiap.gff.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    private String id;
    private String nome;
    private String descricao;
    private Double preco;
    private Integer estoque;
    private Categoria categoria;
}
