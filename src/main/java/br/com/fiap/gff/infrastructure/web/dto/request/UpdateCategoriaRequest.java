package br.com.fiap.gff.infrastructure.web.dto.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCategoriaRequest implements Serializable {
    private String descricao;
}
