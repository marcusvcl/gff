package br.com.fiap.gff.domain.model.entities;

import br.com.fiap.gff.domain.enums.TipoDePagamentoEnum;

public class Pagamento {
    private String Id;
    private String pedidoId;
    private String transacaoId;
    private TipoDePagamentoEnum tipoDePagamento;
    private Double valorAPagar;
    private Double valorPago;
    private String situacao;

    public Pagamento() { }

    public Pagamento(String id, String pedidoId, String transacaoId, TipoDePagamentoEnum tipoDePagamento,
            Double valorAPagar, Double valorPago, String situacao) {
        Id = id;
        this.pedidoId = pedidoId;
        this.transacaoId = transacaoId;
        this.tipoDePagamento = tipoDePagamento;
        this.valorAPagar = valorAPagar;
        this.valorPago = valorPago;
        this.situacao = situacao;
    }

    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
    }
    public String getPedidoId() {
        return pedidoId;
    }
    public void setPedidoId(String pedidoId) {
        this.pedidoId = pedidoId;
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
    public Double getValorAPagar() {
        return valorAPagar;
    }
    public void setValorAPagar(Double valorAPagar) {
        this.valorAPagar = valorAPagar;
    }
    public Double getValorPago() {
        return valorPago;
    }
    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }
    public String getSituacao() {
        return situacao;
    }
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
