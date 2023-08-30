package br.com.fiap.gff.infrastructure.web.dto.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateClienteRequest implements Serializable {
    private String nome;
    private String apelido;
    private String dataNascimento;
    private String email;
    private String telefone;
    private String senha;
}