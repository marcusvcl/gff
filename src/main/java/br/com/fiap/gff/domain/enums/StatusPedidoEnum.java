package br.com.fiap.gff.domain.enums;

public enum StatusPedidoEnum {
    RECEBIDO(1),
    PREPARACAO(2),
    PRONTO(3),
    FINALIZADO(4),
    CANCELADO(5);

    public final Integer ordem;

    private StatusPedidoEnum(Integer ordem) {
        this.ordem = ordem;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public static StatusPedidoEnum toEnum(Integer ordem) {
        if (ordem == null)
            return null;
        StatusPedidoEnum[] status = StatusPedidoEnum.values();
        for (StatusPedidoEnum s : status) {
            if (s.getOrdem().equals(ordem))
                return s;
        }
        return null;
    }
}
