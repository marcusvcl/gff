package br.com.fiap.gff.domain.models;

import br.com.fiap.gff.infrastructure.adapters.output.persistence.entities.ProdutoEntity;
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

    public ProdutoEntity toEntity() {
        return new ProdutoEntity(this.id, this.nome, this.descricao, this.preco, this.estoque, this.categoria);
    }
}
