package br.com.fiap.gff.infrastructure.adapters.input.rest.data.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
