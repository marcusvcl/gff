package br.com.fiap.gff.domain.models;

import br.com.fiap.gff.infrastructure.adapters.output.persistence.entities.CategoriaEntity;
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

}
