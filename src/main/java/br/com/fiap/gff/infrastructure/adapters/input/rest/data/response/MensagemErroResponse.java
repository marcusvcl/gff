package br.com.fiap.gff.infrastructure.adapters.input.rest.data.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MensagemErroResponse {
    private Integer status;
    private String mensagem;
    private Long timeStamp;
}
