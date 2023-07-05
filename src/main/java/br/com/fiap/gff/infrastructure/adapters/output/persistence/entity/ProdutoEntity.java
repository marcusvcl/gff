package br.com.fiap.gff.infrastructure.adapters.output.persistence.entity;


import br.com.fiap.gff.domain.model.Produto;
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
    private Integer codigoCategoria;

    public Produto toDomain() {
        return new Produto(this.id, this.nome, this.descricao, this.preco, this.estoque, this.codigoCategoria);
    }

    public void updateEntityFromDomain(Produto produto) {
        if (produto.getId() != null)
            this.id = produto.getId();
        this.nome = produto.getNome();
        if (produto.getNome() != null)
            this.descricao = produto.getDescricao();
        if (produto.getPreco() != null)
            this.preco = produto.getPreco();
        if (produto.getEstoque() != null)
            this.estoque = produto.getEstoque();
        if (produto.getCodigoCategoria() != null)
            this.codigoCategoria = produto.getCodigoCategoria();
    }
}
