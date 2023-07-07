package br.com.fiap.gff.application.ports.input;

import br.com.fiap.gff.domain.models.Cliente;

import java.util.Collection;

public interface ClienteUseCase {
    Collection<Cliente> obterTodosClientes();
    Cliente obterClientePorId(String id);
    Cliente criarCliente(Cliente cliente);
    Cliente atualizarCliente(Cliente cliente);
    void deletarClientePorId(String id);
}
