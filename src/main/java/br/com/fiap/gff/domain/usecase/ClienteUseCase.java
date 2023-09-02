package br.com.fiap.gff.domain.usecase;

import java.util.Collection;

import br.com.fiap.gff.domain.model.entities.Cliente;

public interface ClienteUseCase {

    Collection<Cliente> obterTodosClientes();

    Cliente obterClientePorId(String id);

    Cliente criarCliente(Cliente cliente);

    Cliente atualizarCliente(Cliente cliente);
    
    void deletarClientePorId(String id);
}
