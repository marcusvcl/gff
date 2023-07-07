package br.com.fiap.gff.domain.models;

import br.com.fiap.gff.infrastructure.adapters.output.persistence.entities.ClienteEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

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
