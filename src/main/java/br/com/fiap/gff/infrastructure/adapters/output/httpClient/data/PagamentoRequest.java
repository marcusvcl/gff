package br.com.fiap.gff.infrastructure.adapters.output.httpClient.data;

import br.com.fiap.gff.domain.enums.TipoDePagamentoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoRequest implements Serializable {
    private String Id;
    private String pedidoId;
    private String transacaoId;
    private TipoDePagamentoEnum tipoDePagamento;
    private Double valorAPagar;
    private Double valorPago;
    private String situacao;
    private Auth auth;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Auth {
        private String userId;
        private String password;
        private String token;
    }
}
