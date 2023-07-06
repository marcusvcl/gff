package br.com.fiap.gff.infrastructure.adapters.output.persistence;

import br.com.fiap.gff.application.ports.output.PedidoOutputPort;
import br.com.fiap.gff.domain.model.Pedido;
import br.com.fiap.gff.infrastructure.adapters.output.persistence.entity.PedidoEntity;
import br.com.fiap.gff.infrastructure.adapters.output.persistence.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PedidoPersistenceAdapter implements PedidoOutputPort {

    private final PedidoRepository repository;

    @Override
    public Pedido salvarPedido(Pedido pedido) {
        PedidoEntity entity = pedido.toEntity();
        return repository.save(entity).toDomain();
    }

    @Override
    public void deletarPedido(Pedido pedido) {
        PedidoEntity entity = pedido.toEntity();
        repository.delete(entity);
    }

    @Override
    public void deletarPedidoPorId(String id) {
        repository.deleteById(id);
    }

    @Override
    public Pedido obterPedidoPorId(String id) {
        Optional<PedidoEntity> entity = repository.findById(id);
        return entity.map(PedidoEntity::toDomain).orElse(null);
    }

    @Override
    public Collection<Pedido> obterTodosPedidos() {
        List<PedidoEntity> entities = repository.findAll();
        return entities.stream().map(PedidoEntity::toDomain).toList();
    }

    @Override
    public Pedido atualizarPedido(Pedido pedido) {
        Optional<PedidoEntity> PedidoAntigo = repository.findById(pedido.getId());
        if (PedidoAntigo.isEmpty())
            throw new RuntimeException("Falha ao atualizar o Pedido");
        PedidoAntigo.ifPresent(PedidoEntity -> PedidoEntity.updateEntityFromDomain(pedido));
        return PedidoAntigo.get().toDomain();
    }
}
