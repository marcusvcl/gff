package br.com.fiap.gff.domain.gateway;

import java.util.Collection;

import br.com.fiap.gff.domain.model.entities.Cliente;

public interface ClienteGateway {
    Cliente salvarCliente(Cliente cliente);

    void deletarCliente(Cliente cliente);

    void deletarClientePorId(String id);

    Cliente obterClientePorId(String id);

    Collection<Cliente> obterTodosClientes();

    Cliente atualizarCliente(Cliente Cliente);
}
