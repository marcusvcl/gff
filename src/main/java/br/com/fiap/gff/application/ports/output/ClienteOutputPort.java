package br.com.fiap.gff.application.ports.output;

import br.com.fiap.gff.domain.models.Cliente;

import java.util.Collection;

public interface ClienteOutputPort {
    Cliente salvarCliente(Cliente cliente);

    void deletarCliente(Cliente cliente);

    void deletarClientePorId(String id);

    Cliente obterClientePorId(String id);

    Collection<Cliente> obterTodosClientes();

    Cliente atualizarCliente(Cliente Cliente);
}
