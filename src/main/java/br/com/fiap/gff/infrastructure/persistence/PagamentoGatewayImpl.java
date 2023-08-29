package br.com.fiap.gff.infrastructure.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import br.com.fiap.gff.domain.gateway.PagamentoGateway;
import br.com.fiap.gff.domain.model.entities.Pagamento;
import br.com.fiap.gff.infrastructure.persistence.mappers.PagamentoPersistenceMapper;
import br.com.fiap.gff.infrastructure.persistence.repositories.PagamentoRepository;

@RequiredArgsConstructor
@Service
public class PagamentoGatewayImpl implements PagamentoGateway {

    private final PagamentoRepository repository;
    private final PagamentoPersistenceMapper mapper;

    @Override
    public Pagamento salvarPagamento(Pagamento pagamento) {
        var entity = mapper.toEntity(pagamento);
        return mapper.toModel(repository.save(entity));
    }

    @Override
    public Pagamento obterPagamentoPeloId(String id) {
        var pagamento = repository.findById(id);
        return pagamento.map(mapper::toModel).orElse(null);
    }

    @Override
    public Pagamento obterPagamentoPelaTransacaoId(String transacaoId) {
        var pagamento = repository.findByTransacaoId(transacaoId);
        return pagamento.map(mapper::toModel).orElse(null);
    }
}
