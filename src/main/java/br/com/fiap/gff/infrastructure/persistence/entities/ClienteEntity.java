package br.com.fiap.gff.infrastructure.persistence.entities;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "clientes")
public class ClienteEntity implements Serializable {
    private String id;
    private String nome;
    private String apelido;
    private String documento;
    private String dataNascimento;
    private String email;
    private String telefone;
    private String senha;
}
