package br.com.fiap.gff.infrastructure.adapters.output.persistence;

import br.com.fiap.gff.application.ports.output.ClienteOutputPort;
import br.com.fiap.gff.domain.model.Cliente;
import br.com.fiap.gff.infrastructure.adapters.output.persistence.entity.ClienteEntity;
import br.com.fiap.gff.infrastructure.adapters.output.persistence.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClientePersistenceAdapter implements ClienteOutputPort {

    private final ClienteRepository repository;

    @Override
    public Cliente salvarCliente(Cliente cliente) {
        ClienteEntity entity = cliente.toEntity();
        return repository.save(entity).toDomain();
    }

    @Override
    public void deletarCliente(Cliente cliente) {
        ClienteEntity entity = cliente.toEntity();
        repository.delete(entity);
    }

    @Override
    public void deletarClientePorId(String id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Cliente> obterClientePorId(String id) {
        Optional<ClienteEntity> entity = repository.findById(id);
        return entity.map(ClienteEntity::toDomain);
    }

    @Override
    public Optional<Collection<Cliente>> obterTodosClientes() {
        List<ClienteEntity> entities = repository.findAll();
        return Optional.of(entities.stream().map(ClienteEntity::toDomain).toList());
    }

    @Override
    public Cliente atualizarCliente(Cliente cliente) {
        Optional<ClienteEntity> ClienteAntigo = repository.findById(cliente.getId());
        if (ClienteAntigo.isEmpty())
            throw new RuntimeException("Falha ao atualizar o Cliente");
        ClienteAntigo.ifPresent(ClienteEntity -> ClienteEntity.updateEntityFromDomain(cliente));
        return ClienteAntigo.get().toDomain();
    }
}
