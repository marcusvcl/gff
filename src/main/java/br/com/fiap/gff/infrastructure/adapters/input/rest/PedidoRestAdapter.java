package br.com.fiap.gff.infrastructure.adapters.input.rest;

import br.com.fiap.gff.application.ports.input.PedidoUseCase;
import br.com.fiap.gff.domain.model.Pedido;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/v1")
@Tag(name = "pedidos")
@RequiredArgsConstructor
public class PedidoRestAdapter {

    private final PedidoUseCase useCase;

    @PostMapping(value = "/pedidos")
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
        pedido = useCase.criarPedido(pedido);
        return new ResponseEntity<>(pedido, HttpStatus.CREATED);
    }

    @GetMapping(value = "/pedidos")
    public ResponseEntity<Collection<Pedido>> obterTodosPedidos() {
        Collection<Pedido> Pedidos = useCase.obterTodosPedidos();
        return new ResponseEntity<>(Pedidos, HttpStatus.OK);
    }
}
