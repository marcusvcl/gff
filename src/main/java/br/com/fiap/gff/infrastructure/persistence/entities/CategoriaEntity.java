package br.com.fiap.gff.infrastructure.persistence.entities;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
