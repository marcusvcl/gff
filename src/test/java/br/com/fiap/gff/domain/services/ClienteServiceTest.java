package br.com.fiap.gff.domain.services;

import br.com.fiap.gff.application.ports.output.ClienteOutputPort;
import br.com.fiap.gff.domain.exceptions.RecursoNaoEncontradoException;
import br.com.fiap.gff.domain.models.Cliente;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @Mock
    ClienteOutputPort outputPort;
    @InjectMocks
    ClienteService service;

    @Test
    void DeveObterTodosClientes() {
        var c1 = new Cliente("id","nome", "apelido", "documento", "dataNascimento", "email", "telefone", "senha");
        var c2 = new Cliente("id","nome", "apelido", "documento", "dataNascimento", "email", "telefone", "senha");
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
        var c1 = new Cliente("id","nome", "apelido", "documento", "dataNascimento", "email", "telefone", "senha");
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
        var c1 = new Cliente("id","nome", "apelido", "documento", "dataNascimento", "email", "telefone", "senha");
        when(outputPort.salvarCliente(c1)).thenReturn(c1);
        var result = service.criarCliente(c1);
        assertEquals(c1, result);
    }

    @Test
    void DeveAtualizarUmCliente() {
        var c1 = new Cliente("id","nome", "apelido", "documento", "dataNascimento", "email", "telefone", "senha");
        when(outputPort.atualizarCliente(c1)).thenReturn(c1);
        var result = service.atualizarCliente(c1);
        assertEquals(c1, result);
    }
}