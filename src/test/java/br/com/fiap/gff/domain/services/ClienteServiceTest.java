package br.com.fiap.gff.domain.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.fiap.gff.domain.exceptions.RecursoNaoEncontradoException;
import br.com.fiap.gff.domain.gateway.ClienteGateway;
import br.com.fiap.gff.domain.model.entities.Cliente;
import br.com.fiap.gff.domain.service.ClienteService;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @Mock
    ClienteGateway outputPort;
    @InjectMocks
    ClienteService service;

    @Test
    void DeveObterTodosClientes() {
        var c1 = new Cliente("id", "nome", "apelido", "documento", "dataNascimento", "email", "telefone", "senha");
        var c2 = new Cliente("id", "nome", "apelido", "documento", "dataNascimento", "email", "telefone", "senha");
        var clientes = new ArrayList<Cliente>(Arrays.asList(c1, c2));
        when(outputPort.obterTodosClientes()).thenReturn(clientes);
        var result = service.obterTodosClientes();
        assertEquals(2, result.size());
    }

    @Test
    void DeveLancarExcecaoCasoNaoTenhaNenhumClienteNaBase() {
        when(outputPort.obterTodosClientes()).thenReturn(null);
        Throwable ex = assertThrows(RecursoNaoEncontradoException.class, () -> service.obterTodosClientes());
        assertEquals("Nenhum cliente cadastrado no sistema.", ex.getMessage());
    }

    @Test
    void DeveRetornarUmClienteAoConsultarPorId() {
        var c1 = new Cliente("id", "nome", "apelido", "documento", "dataNascimento", "email", "telefone", "senha");
        when(outputPort.obterClientePorId("id")).thenReturn(c1);
        var result = service.obterClientePorId("id");
        assertEquals("apelido", result.getApelido());
    }

    @Test
    void DeveLancarExcecaoCasoNaoTenhaNenhumClienteComOIdInformadoNaBase() {
        when(outputPort.obterClientePorId("id")).thenReturn(null);
        Throwable ex = assertThrows(RecursoNaoEncontradoException.class, () -> service.obterClientePorId("id"));
        assertEquals("Não foi encontrado nenhum cliente para o id id", ex.getMessage());
    }

    @Test
    void DeveCriarUmCliente() {
        var c1 = new Cliente("id", "nome", "apelido", "documento", "dataNascimento", "email", "telefone", "senha");
        when(outputPort.salvarCliente(c1)).thenReturn(c1);
        var result = service.criarCliente(c1);
        assertEquals(c1, result);
    }

    @Test
    void DeveAtualizarUmCliente() {
        var c1 = new Cliente("id", "nome", "apelido", "documento", "dataNascimento", "email", "telefone", "senha");
        when(outputPort.atualizarCliente(c1)).thenReturn(c1);
        var result = service.atualizarCliente(c1);
        assertEquals(c1, result);
    }
}