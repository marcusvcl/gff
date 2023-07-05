package br.com.fiap.gff.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusPedidoEnum {
    RECEBIDO(1),
    PREPARACAO(2),
    PRONTO(3),
    FINALIZADO(4);

    public final Integer ordem;

    public static StatusPedidoEnum toEnum(Integer ordem) {
        if (ordem == null)
            return null;
        StatusPedidoEnum[] status = StatusPedidoEnum.values();
        for (StatusPedidoEnum s : status) {
            if (s.getOrdem().equals(ordem)) return s;
        }
        return null;
    }
}
