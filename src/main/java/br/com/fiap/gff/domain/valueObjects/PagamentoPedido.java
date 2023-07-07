package br.com.fiap.gff.domain.valueObjects;

import br.com.fiap.gff.domain.enums.TipoDePagamentoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoPedido {
    private String transacaoId;
    private TipoDePagamentoEnum tipoDePagamento;
    private double valorPago;
}
