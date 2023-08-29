package br.com.fiap.gff.infrastructure.httpclient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import br.com.fiap.gff.domain.gateway.PagamentoGateway;
import br.com.fiap.gff.domain.model.entities.Pedido;
import br.com.fiap.gff.domain.usecase.PagamentoUseCase;
import br.com.fiap.gff.infrastructure.httpclient.data.PagamentoRequest;
import br.com.fiap.gff.infrastructure.httpclient.data.PagamentoResponse;
import br.com.fiap.gff.infrastructure.httpclient.mappers.PagamentoHttpMapper;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PagamentoHttpAdpater implements PagamentoUseCase {

    private final PagamentoHttpMapper mapper;
    private final PagamentoGateway gateway;

    @Override
    public Pedido executarPagamento(Pedido pedido) {
        var request = new PagamentoRequest();
        request.setPedidoId(pedido.getId());
        request.setTipoDePagamento(pedido.getPagamento().getTipoDePagamento());
        request.setValorAPagar(pedido.getTotalPedido());
        request.setSituacao("PENDENTE");
        request.setAuth(new PagamentoRequest.Auth());
        var response = enviarPagamentoAoParceiro(request);
        var pagamento = gateway.salvarPagamento(mapper.toModel(response));
        pedido.getPagamento().setValorPago(pagamento.getValorPago());
        pedido.getPagamento().setTransacaoId(pagamento.getTransacaoId());
        return pedido;
    }

    private PagamentoResponse enviarPagamentoAoParceiro(PagamentoRequest request) {
        autenticarParceiro(request);
        var response = new PagamentoResponse();
        response.setPedidoId(request.getPedidoId());
        response.setTransacaoId(UUID.randomUUID().toString());
        response.setTipoDePagamento(response.getTipoDePagamento());
        response.setValorAPagar(request.getValorAPagar());
        response.setValorPago(request.getValorAPagar());
        response.setSituacao("PAGO");
        return response;
    }

    private void autenticarParceiro(PagamentoRequest request) {
        request.getAuth().setUserId("aaaa");
        request.getAuth().setPassword("aaaa");
        obterToken(request);
    }

    private void obterToken(PagamentoRequest request) {
        request.getAuth().setToken(UUID.randomUUID().toString());
    }
}
