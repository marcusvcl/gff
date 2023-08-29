package br.com.fiap.gff.domain.model.entities;

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
