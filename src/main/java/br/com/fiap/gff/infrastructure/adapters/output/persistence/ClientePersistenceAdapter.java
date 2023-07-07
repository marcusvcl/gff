package br.com.fiap.gff.infrastructure.adapters.output.persistence;

import br.com.fiap.gff.application.ports.output.ClienteOutputPort;
import br.com.fiap.gff.domain.models.Cliente;
import br.com.fiap.gff.infrastructure.adapters.output.persistence.entities.ClienteEntity;
import br.com.fiap.gff.infrastructure.adapters.output.persistence.mappers.ClientePersistenceMapper;
import br.com.fiap.gff.infrastructure.adapters.output.persistence.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClientePersistenceAdapter implements ClienteOutputPort {

    private final ClienteRepository repository;
    private final ClientePersistenceMapper mapper;

    @Override
    public Cliente salvarCliente(Cliente cliente) {
        ClienteEntity entity =  mapper.toEntity(cliente);
        return mapper.toModel(repository.save(entity));
    }

    @Override
    public void deletarCliente(Cliente cliente) {
        ClienteEntity entity = mapper.toEntity(cliente);
        repository.delete(entity);
    }

    @Override
    public void deletarClientePorId(String id) {
        repository.deleteById(id);
    }

    @Override
    public Cliente obterClientePorId(String id) {
        Optional<ClienteEntity> entity = repository.findById(id);
        return entity.map(mapper::toModel).orElse(null);
    }

    @Override
    public Collection<Cliente> obterTodosClientes() {
        List<ClienteEntity> entities = repository.findAll();
        return entities.stream().map(mapper::toModel).toList();
    }

    @Override
    public Cliente atualizarCliente(Cliente cliente) {
        Optional<ClienteEntity> clienteAntigo = repository.findById(cliente.getId());
        if (clienteAntigo.isEmpty())
            throw new RuntimeException("Falha ao atualizar o Cliente");
        clienteAntigo.ifPresent(clienteEntity -> mapper.updateEntityFromModel(cliente, clienteEntity));
        return mapper.toModel(clienteAntigo.get());
    }
}
