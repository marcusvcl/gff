package br.com.fiap.gff.domain.model.valueobjects;

import br.com.fiap.gff.domain.enums.StatusPedidoEnum;

public class StatusPedido {
    private StatusPedidoEnum status;
    private String descricao;

    public StatusPedido() {
    }

    public StatusPedido(StatusPedidoEnum status, String descricao) {
        this.status = status;
        this.descricao = descricao;
    }

    public StatusPedidoEnum getStatus() {
        return status;
    }

    public void setStatus(StatusPedidoEnum status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
