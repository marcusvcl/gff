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

    public ProdutoEntity(String id, String nome, String descricao, Double preco, Integer estoque, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
        this.categoria = new CategoriaProduto(categoria.getId(), categoria.getCodigo(), categoria.getDescricao());
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CategoriaProduto {
        private String Id;
        private Integer codigo;
        private String descricao;
    }

    public Produto toDomain() {
        Categoria categoria = new Categoria(this.categoria.getId(), this.categoria.getCodigo(), this.categoria.getDescricao());
        return new Produto(this.id, this.nome, this.descricao, this.preco, this.estoque, categoria);
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
        if (produto.getCategoria() != null) {
            this.categoria = new CategoriaProduto(produto.getCategoria().getId(),
                    produto.getCategoria().getCodigo(),
                    produto.getCategoria().getDescricao());
        }
    }
}
