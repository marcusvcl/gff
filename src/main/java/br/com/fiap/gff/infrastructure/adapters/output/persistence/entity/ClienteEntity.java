package br.com.fiap.gff.infrastructure.adapters.output.persistence.entity;

import br.com.fiap.gff.domain.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "clientes")
public class ClienteEntity {
    private String id;
    private String nome;
    private String documento;
    private String email;
    private String telefone;
    //TODO Mudar o tipo de string para hash
    private String senha;

    public Cliente toDomain() {
        return new Cliente(this.id, this.nome, this.documento, this.email, this.telefone, this.senha);
    }

    public void updateEntityFromDomain(Cliente domain) {
        if (domain.getId() != null)
            this.id = domain.getId();
        if (domain.getNome() != null)
            this.nome = domain.getNome();
        if (domain.getDocumento() != null)
            this.documento = domain.getDocumento();
        if (domain.getTelefone() != null)
            this.telefone = domain.getTelefone();
        if (domain.getSenha() != null)
            this.senha = domain.getSenha();
    }
}
