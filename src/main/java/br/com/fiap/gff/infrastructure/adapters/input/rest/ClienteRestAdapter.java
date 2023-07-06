package br.com.fiap.gff.infrastructure.adapters.input.rest;

import br.com.fiap.gff.application.ports.input.ClienteUseCase;
import br.com.fiap.gff.domain.model.Cliente;
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

    @PostMapping(value = "/clientes")
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        cliente = useCase.criarCliente(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    @GetMapping(value = "/clientes")
    public ResponseEntity<Collection<Cliente>> obterTodosClientes() {
        Collection<Cliente> Clientes = useCase.obterTodosClientes();
        return new ResponseEntity<>(Clientes, HttpStatus.OK);
    }
}
