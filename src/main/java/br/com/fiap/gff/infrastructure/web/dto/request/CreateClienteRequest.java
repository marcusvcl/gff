package br.com.fiap.gff.infrastructure.web.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateClienteRequest implements Serializable {
    private String nome;
    private String apelido;
    private String documento;
    private String dataNascimento;
    private String email;
    private String telefone;
    private String senha;
}
