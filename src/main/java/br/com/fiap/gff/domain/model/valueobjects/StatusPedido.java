package br.com.fiap.gff.domain.model.valueobjects;

import br.com.fiap.gff.domain.enums.StatusPedidoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusPedido {
    private StatusPedidoEnum status;
    private String descricao;
}
