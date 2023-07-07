package br.com.fiap.gff.domain.models;

import br.com.fiap.gff.domain.enums.TipoDePagamentoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pagamento {
    private String Id;
    private String pedidoId;
    private String transacaoId;
    private TipoDePagamentoEnum tipoDePagamento;
    private Double valorAPagar;
    private Double valorPago;
    private String situacao;
}
