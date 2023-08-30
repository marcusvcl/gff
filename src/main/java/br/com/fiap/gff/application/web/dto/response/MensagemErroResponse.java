package br.com.fiap.gff.application.web.dto.response;

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
