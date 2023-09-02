package br.com.fiap.gff.domain.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import br.com.fiap.gff.domain.exceptions.RecursoNaoEncontradoException;
import br.com.fiap.gff.domain.gateway.ClienteGateway;
import br.com.fiap.gff.domain.model.entities.Cliente;
import br.com.fiap.gff.domain.usecase.ClienteUseCase;

@Service
public class ClienteService implements ClienteUseCase {

    private final ClienteGateway clienteGateway;

    public ClienteService(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    @Override
    public Collection<Cliente> obterTodosClientes() {
        var clientes = clienteGateway.obterTodosClientes();
        if (clientes == null || clientes.size() == 0)
            throw new RecursoNaoEncontradoException("Nenhum cliente cadastrado no sistema.");
        return clientes;
    }

    @Override
    public Cliente obterClientePorId(String id) {
        var cliente = clienteGateway.obterClientePorId(id);
        if (cliente == null)
            throw new RecursoNaoEncontradoException("Não foi encontrado nenhum cliente para o id " + id);
        return cliente;
    }

    @Override
    public Cliente criarCliente(Cliente cliente) {
        return clienteGateway.salvarCliente(cliente);
    }

    @Override
    public Cliente atualizarCliente(Cliente cliente) {
        return clienteGateway.atualizarCliente(cliente);
    }

    @Override
    public void deletarClientePorId(String id) {
        clienteGateway.deletarClientePorId(id);
    }
}
