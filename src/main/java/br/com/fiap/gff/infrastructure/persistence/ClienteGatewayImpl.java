package br.com.fiap.gff.infrastructure.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import br.com.fiap.gff.domain.gateway.ClienteGateway;
import br.com.fiap.gff.domain.model.entities.Cliente;
import br.com.fiap.gff.infrastructure.persistence.entities.ClienteEntity;
import br.com.fiap.gff.infrastructure.persistence.mappers.ClientePersistenceMapper;
import br.com.fiap.gff.infrastructure.persistence.repositories.ClienteRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClienteGatewayImpl implements ClienteGateway {

    private final ClienteRepository repository;
    private final ClientePersistenceMapper mapper;

    @Override
    public Cliente salvarCliente(Cliente cliente) {
        ClienteEntity entity = mapper.toEntity(cliente);
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
        var clienteAtualizado = repository.save(clienteAntigo.get());
        return mapper.toModel(clienteAtualizado);
    }
}
