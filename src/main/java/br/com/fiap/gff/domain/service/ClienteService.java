package br.com.fiap.gff.domain.service;

import br.com.fiap.gff.application.ports.input.ClienteUseCase;
import br.com.fiap.gff.application.ports.output.ClienteOutputPort;
import br.com.fiap.gff.domain.exceptions.RecursoNaoEncontradoException;
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
        Collection<Cliente> clientes = clienteOutput.obterTodosClientes();
        if (clientes == null)
            throw new RecursoNaoEncontradoException("Nenhum cliente cadastrado no sistema.");
        return clientes;
    }

    @Override
    public Cliente obterClientePorId(String id) {
        Cliente cliente = clienteOutput.obterClientePorId(id);
        if (cliente == null)
            throw new RecursoNaoEncontradoException("Não foi encontrado nenhum cliente para o id " + id);
        return cliente;
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
