package br.com.fiap.gff.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusPedidoEnum {
    RECEBIDO(1),
    AGUARDANDOPAGAMENTO(2),
    PREPARACAO(3),
    PRONTO(4),
    FINALIZADO(5),
    CANCELADO(6);

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
