package br.com.fiap.gff.domain.model;

import br.com.fiap.gff.infrastructure.adapters.output.persistence.entity.ClienteEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    private String id;
    private String nome;
    private String documento;
    private String email;
    private String telefone;
    //TODO Mudar o tipo de string para hash
    private String senha;

    public ClienteEntity toEntity() {
        return new ClienteEntity(this.id, this.nome, this.documento, this.email, this.telefone, this.senha);
    }

}
