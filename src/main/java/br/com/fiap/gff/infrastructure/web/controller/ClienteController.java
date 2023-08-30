package br.com.fiap.gff.infrastructure.web.controller;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.gff.domain.model.entities.Cliente;
import br.com.fiap.gff.domain.usecase.ClienteUseCase;
import br.com.fiap.gff.infrastructure.web.dto.request.CreateClienteRequest;
import br.com.fiap.gff.infrastructure.web.dto.request.UpdateClienteRequest;
import br.com.fiap.gff.infrastructure.web.mapper.ClienteRestMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1")
@Tag(name = "clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteUseCase useCase;
    private final ClienteRestMapper mapper;

    @GetMapping(value = "/clientes")
    @Operation(summary = "Lista todos os clientes cadastrados na base.")
    public ResponseEntity<Collection<Cliente>> obterTodosClientes() {
        var clientes = useCase.obterTodosClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping(value = "/clientes/{id}")
    @Operation(summary = "Obtém um cliente pelo id informado.")
    public ResponseEntity<Cliente> obterClientePorId(@PathVariable String id) {
        var cliente = useCase.obterClientePorId(id);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @PostMapping(value = "/clientes")
    @Operation(summary = "Cria um cliente a partir dos dados informados.")
    public ResponseEntity<Cliente> criarCliente(@RequestBody CreateClienteRequest request) {
        var cliente = useCase.criarCliente(mapper.toModel(request));
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    @PutMapping(value = "/clientes/{id}")
    @Operation(summary = "Atualiza as informações do cliente com base nos dados informados.")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable String id,
            @RequestBody UpdateClienteRequest request) {
        var cliente = mapper.toModel(request);
        cliente.setId(id);
        cliente = useCase.atualizarCliente(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @DeleteMapping(value = "/clientes/{id}")
    @Operation(summary = "Deletar um cliente pelo id.")
    public ResponseEntity<String> deletarClientePorId(String id) {
        useCase.deletarClientePorId(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
