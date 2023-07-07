package br.com.fiap.gff.infrastructure.adapters.output.persistence;

import br.com.fiap.gff.application.ports.output.PedidoOutputPort;
import br.com.fiap.gff.domain.models.Pedido;
import br.com.fiap.gff.infrastructure.adapters.output.persistence.entities.PedidoEntity;
import br.com.fiap.gff.infrastructure.adapters.output.persistence.mappers.PedidoPersistenceMapper;
import br.com.fiap.gff.infrastructure.adapters.output.persistence.repositories.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PedidoPersistenceAdapter implements PedidoOutputPort {

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
    public Pedido atualizarPedido(Pedido pedido) {
        PedidoEntity entity = mapper.toEntity(pedido);
        return mapper.toModel(repository.save(entity));
    }
}
