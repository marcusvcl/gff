package br.com.fiap.gff.domain.model.valueobjects;

import br.com.fiap.gff.domain.enums.StatusPagamentoEnum;
import br.com.fiap.gff.domain.enums.TipoDePagamentoEnum;

public class PagamentoPedido {
    private String transacaoId;
    private TipoDePagamentoEnum tipoDePagamento;
    private double valorPago;
    private StatusPagamentoEnum status;

    public PagamentoPedido() {
    }

    public PagamentoPedido(String transacaoId, TipoDePagamentoEnum tipoDePagamento, double valorPago,
            StatusPagamentoEnum status) {
        this.transacaoId = transacaoId;
        this.tipoDePagamento = tipoDePagamento;
        this.valorPago = valorPago;
        this.status = status;
    }

    public String getTransacaoId() {
        return transacaoId;
    }

    public void setTransacaoId(String transacaoId) {
        this.transacaoId = transacaoId;
    }

    public TipoDePagamentoEnum getTipoDePagamento() {
        return tipoDePagamento;
    }

    public void setTipoDePagamento(TipoDePagamentoEnum tipoDePagamento) {
        this.tipoDePagamento = tipoDePagamento;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public void setStatus(StatusPagamentoEnum status) {
        this.status = status;
    }

    public StatusPagamentoEnum getStatus() {
        return status;
    }
}
