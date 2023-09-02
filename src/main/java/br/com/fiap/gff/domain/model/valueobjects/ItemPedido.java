package br.com.fiap.gff.domain.model.valueobjects;

import java.util.Objects;

import br.com.fiap.gff.domain.exceptions.RequisicaoInvalidaException;

public class ItemPedido {
    private String produtoId;
    private String nome;
    private Double preco;
    private Integer quantidade;

    public ItemPedido() {
    }

    public ItemPedido(String produtoId, String nome, Double preco, Integer quantidade) {
        this.produtoId = produtoId;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(String produtoId) {
        this.produtoId = produtoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void validateState() {
        Objects.requireNonNull(this.produtoId, "Não se pode adicionar um item sem produto");
        if (this.quantidade <= 0)
            throw new RequisicaoInvalidaException("Não se pode adicionar um item com quantidade negativa");
        if (this.preco < 0)
            throw new RequisicaoInvalidaException("Não se pode adicionar um item com preço negativo");
    }

}
