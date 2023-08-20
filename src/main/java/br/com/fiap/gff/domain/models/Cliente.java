package br.com.fiap.gff.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    private String id;
    private String nome;
    private String apelido;
    private String documento;
    private String dataNascimento;
    private String email;
    private String telefone;
    private String senha;
}
