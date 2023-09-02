package br.com.fiap.gff.application.web.controller;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.gff.application.web.dto.request.CreatePedidoRequest;
import br.com.fiap.gff.application.web.dto.request.UpdatePedidoRequest;
import br.com.fiap.gff.application.web.mapper.PedidoRestMapper;
import br.com.fiap.gff.domain.model.entities.Pedido;
import br.com.fiap.gff.domain.usecase.PedidoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1")
@Tag(name = "pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoUseCase useCase;
    private final PedidoRestMapper mapper;

    @GetMapping(value = "/pedidos")
    @Operation(summary = "Lista todos os pedidos por ordem de data.")
    public ResponseEntity<Collection<Pedido>> obterTodosPedidos() {
        var Pedidos = useCase.obterTodosPedidos();
        return new ResponseEntity<>(Pedidos, HttpStatus.OK);
    }

    @PostMapping(value = "/pedidos")
    @Operation(summary = "Cria um pedido a partir dos dados informados.")
    public ResponseEntity<Pedido> criarPedido(@RequestBody CreatePedidoRequest request) {
        var pedido = mapper.toModel(request);
        pedido = useCase.criarPedido(pedido);
        return new ResponseEntity<>(pedido, HttpStatus.CREATED);
    }

    @PostMapping(value = "/pedidos/{id}/checkout")
    @Operation(summary = "Envia o pedido informado para pagamento.")
    public ResponseEntity<Pedido> checkoutPedido(@PathVariable String id) {
        var pedido = useCase.realizarCheckout(id);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }

    @PutMapping(value = "/pedidos/{id}/items")
    @Operation(summary = "Atualiza os itens de um pedido a partir dos dados informados.")
    public ResponseEntity<Pedido> atualizarItemsPedido(@PathVariable String id,
            @RequestBody UpdatePedidoRequest request) {
        var pedido = mapper.toModel(request);
        pedido.setId(id);
        var pedidoAtualizado = useCase.atualizarPedido(pedido);
        return new ResponseEntity<>(pedidoAtualizado, HttpStatus.OK);
    }

    @PutMapping(value = "/pedidos/{id}/items/remover/{produtoId}")
    @Operation(summary = "Remove determinado produto da lista dos items.")
    public ResponseEntity<Pedido> removerItemPedido(@PathVariable String id, @PathVariable String produtoId) {
        var pedido = useCase.removerItemPedido(id, produtoId);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }

    @PutMapping(value = "/pedidos/{id}/status/{statusPedido}")
    @Operation(summary = "Atualiza o status de um pedido a partir dos dados informados.")
    public ResponseEntity<Pedido> atualizarStatusPedido(@PathVariable String id, @PathVariable String statusPedido) {
        var pedido = useCase.atualizarStatusPedido(id, statusPedido);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }
}
