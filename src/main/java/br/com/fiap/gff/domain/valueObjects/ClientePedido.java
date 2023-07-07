package br.com.fiap.gff.domain.valueObjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientePedido {
    private String id;
    private String nome;
    private String apelido;
}
