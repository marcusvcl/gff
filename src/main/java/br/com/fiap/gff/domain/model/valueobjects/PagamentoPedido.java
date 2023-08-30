package br.com.fiap.gff.domain.model.valueobjects;

import br.com.fiap.gff.domain.enums.TipoDePagamentoEnum;

public class PagamentoPedido {
    private String transacaoId;
    private TipoDePagamentoEnum tipoDePagamento;
    private double valorPago;

    public PagamentoPedido() {
    }

    public PagamentoPedido(String transacaoId, TipoDePagamentoEnum tipoDePagamento, double valorPago) {
        this.transacaoId = transacaoId;
        this.tipoDePagamento = tipoDePagamento;
        this.valorPago = valorPago;
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

}
