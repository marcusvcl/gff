package br.com.fiap.gff.infrastructure.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "categorias")
public class CategoriaEntity implements Serializable {
    @Id
    private String id;
    private Integer codigo;
    private String descricao;

}
