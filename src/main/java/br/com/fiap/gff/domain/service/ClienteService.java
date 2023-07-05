package br.com.fiap.gff.domain.service;

import br.com.fiap.gff.application.ports.input.ClienteUseCase;
import br.com.fiap.gff.application.ports.output.ClienteOutputPort;
import br.com.fiap.gff.domain.model.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClienteService implements ClienteUseCase {

    private final ClienteOutputPort clienteOutput;

    @Override
    public Collection<Cliente> obterTodosClientes() {
        Optional<Collection<Cliente>> clientes = clienteOutput.obterTodosClientes();
        return clientes.orElse(null);
    }

    @Override
    public Optional<Cliente> obterClientePorId(String id) {
        return clienteOutput.obterClientePorId(id);
    }

    @Override
    public Cliente criarCliente(Cliente cliente) {
        return clienteOutput.salvarCliente(cliente);
    }

    @Override
    public Cliente atualizarCliente(Cliente cliente) {
        return clienteOutput.atualizarCliente(cliente);
    }

    @Override
    public void deletarClientePorId(String id) {
        clienteOutput.deletarClientePorId(id);
    }
}
