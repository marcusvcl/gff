package br.com.fiap.gff.infrastructure.adapters.input.rest;

import br.com.fiap.gff.application.ports.input.ClienteUseCase;
import br.com.fiap.gff.domain.models.Cliente;
import br.com.fiap.gff.infrastructure.adapters.input.rest.data.request.CreateClienteRequest;
import br.com.fiap.gff.infrastructure.adapters.input.rest.data.request.UpdateClienteRequest;
import br.com.fiap.gff.infrastructure.adapters.input.rest.mapper.ClienteRestMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/v1")
@Tag(name = "clientes")
@RequiredArgsConstructor
public class ClienteRestAdapter {

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
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable String id, @RequestBody UpdateClienteRequest request) {
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
