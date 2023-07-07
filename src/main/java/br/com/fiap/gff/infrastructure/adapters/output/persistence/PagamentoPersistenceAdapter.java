package br.com.fiap.gff.infrastructure.adapters.output.persistence;

import br.com.fiap.gff.application.ports.output.PagamentoOutputPort;
import br.com.fiap.gff.domain.models.Pagamento;
import br.com.fiap.gff.infrastructure.adapters.output.persistence.mappers.PagamentoPersistenceMapper;
import br.com.fiap.gff.infrastructure.adapters.output.persistence.repositories.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PagamentoPersistenceAdapter implements PagamentoOutputPort {

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
