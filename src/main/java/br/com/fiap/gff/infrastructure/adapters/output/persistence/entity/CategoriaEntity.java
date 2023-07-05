package br.com.fiap.gff.infrastructure.adapters.output.persistence.entity;

import br.com.fiap.gff.domain.model.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "categorias")
public class CategoriaEntity {
    @Id
    private String id;
    private Integer codigo;
    private String descricao;

    public Categoria toDomain() {
        return new Categoria(this.id, this.codigo, this.descricao);
    }

    public void updateEntityFromDomain(Categoria domain) {
        if (domain.getId() != null)
            this.id = domain.getId();
        if (domain.getCodigo() != null)
            this.codigo = domain.getCodigo();
        if (domain.getDescricao() != null)
            this.descricao = domain.getDescricao();
    }
}
