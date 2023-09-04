package br.com.fiap.gff.infrastructure.persistence;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.fiap.gff.domain.enums.StatusPagamentoEnum;
import br.com.fiap.gff.domain.gateway.PedidoGateway;
import br.com.fiap.gff.domain.model.entities.Pedido;
import br.com.fiap.gff.infrastructure.persistence.entities.PedidoEntity;
import br.com.fiap.gff.infrastructure.persistence.mappers.PedidoPersistenceMapper;
import br.com.fiap.gff.infrastructure.persistence.repositories.PedidoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PedidoGatewayImpl implements PedidoGateway {

    private final PedidoRepository repository;
    private final PedidoPersistenceMapper mapper;

    @Override
    public Pedido salvarPedido(Pedido pedido) {
        PedidoEntity entity = mapper.toEntity(pedido);
        return mapper.toModel(repository.save(entity));
    }

    @Override
    public void deletarPedido(Pedido pedido) {
        PedidoEntity entity = mapper.toEntity(pedido);
        repository.delete(entity);
    }

    @Override
    public void deletarPedidoPorId(String id) {
        repository.deleteById(id);
    }

    @Override
    public Pedido obterPedidoPorId(String id) {
        Optional<PedidoEntity> entity = repository.findById(id);
        return entity.map(mapper::toModel).orElse(null);
    }

    @Override
    public Collection<Pedido> obterTodosPedidos() {
        List<PedidoEntity> entities = repository.findAll();
        return entities.stream().map(mapper::toModel).toList();
    }

    @Override
    public StatusPagamentoEnum obterStatusDoPagamento(String id) {
        Optional<PedidoEntity> entity = repository.findById(id);
        return entity.stream().map(x -> x.getPagamento().getStatus()).findFirst().orElse(null);
    }

    @Override
    public Pedido atualizarPedido(Pedido pedido) {
        PedidoEntity entity = mapper.toEntity(pedido);
        return mapper.toModel(repository.save(entity));
    }
}
