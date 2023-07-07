package br.com.fiap.gff.domain.valueObjects;

import br.com.fiap.gff.domain.exceptions.RequisicaoInvalidaException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class ItemPedido {
    private String produtoId;
    private String nome;
    private Double preco;
    private Integer quantidade;

    public void validateState() {
        Objects.requireNonNull(this.produtoId, "Não se pode adicionar um item sem produto");
        if (this.quantidade < 0)
            throw new RequisicaoInvalidaException("Não se pode adicionar um item com quantidade negativa");
        if (this.preco < 0)
            throw new RequisicaoInvalidaException("Não se pode adicionar um item com preço negativo");
    }
}
