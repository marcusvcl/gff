package br.com.fiap.gff.infrastructure.persistence.entities;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import br.com.fiap.gff.domain.enums.TipoDePagamentoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "pagamentos")
public class PagamentoEntity implements Serializable {
    private String Id;
    private String pedidoId;
    private String transacaoId;
    private TipoDePagamentoEnum tipoDePagamento;
    private Double valorAPagar;
    private Double valorPago;
    private String situacao;
}
