package br.com.fiap.gff.domain.model;

import br.com.fiap.gff.infrastructure.adapters.output.persistence.entity.CategoriaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {
    private String id;
    private Integer codigo;
    private String descricao;

    public CategoriaEntity toEntity() {
        return new CategoriaEntity(this.id, this.codigo, this.descricao);
    }
}
