package br.com.fiap.gff.infrastructure.persistence.entities;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "produtos")
public class ProdutoEntity implements Serializable {

    @Id
    private String id;
    private String nome;
    private String descricao;
    private Double preco;
    private Integer estoque;
    private CategoriaProduto categoria;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CategoriaProduto {
        private String Id;
        private Integer codigo;
        private String descricao;
    }
}
