package br.com.fiap.gff.infrastructure.adapters.output.persistence.entities;


import br.com.fiap.gff.domain.models.Categoria;
import br.com.fiap.gff.domain.models.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


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
