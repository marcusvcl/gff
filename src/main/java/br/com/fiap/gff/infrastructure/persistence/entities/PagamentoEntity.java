package br.com.fiap.gff.infrastructure.persistence.entities;

import br.com.fiap.gff.domain.enums.TipoDePagamentoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

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
