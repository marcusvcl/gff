package br.com.fiap.gff.infrastructure.adapters.input.rest;

import br.com.fiap.gff.application.ports.input.ProdutoUseCase;
import br.com.fiap.gff.domain.models.Produto;
import br.com.fiap.gff.infrastructure.adapters.input.rest.data.request.CreateProdutoRequest;
import br.com.fiap.gff.infrastructure.adapters.input.rest.mapper.ProdutoRestMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/v1")
@Tag(name = "produtos")
@RequiredArgsConstructor
public class ProdutoRestAdapter {

    private final ProdutoUseCase produtoUseCase;
    private final ProdutoRestMapper mapper;

    @GetMapping(value = "/produtos")
    @Operation(summary = "Lista todos os produtos cadastrados na base.")
    public ResponseEntity<Collection<Produto>> obterTodosProdutos() {
        Collection<Produto> produtos = produtoUseCase.obterTodosProdutos();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping(value = "/produtos/categoria/{codigoCategoria}")
    @Operation(summary = "Recupera todos os produtos de uma determinada categoria.")
    public ResponseEntity<Collection<Produto>> obterProdutoPorCategoria(@PathVariable Integer codigoCategoria) {
        Collection<Produto> produtos = produtoUseCase.obterProdutoPorCategoria(codigoCategoria);
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @PostMapping(value = "/produtos")
    @Operation(summary = "Cria um produto a partir dos dados informados.")
    public ResponseEntity<Produto> criarProduto(@RequestBody CreateProdutoRequest request) {
        Produto domain = mapper.toDomain(request);
        domain = produtoUseCase.criarProduto(domain);
        return new ResponseEntity<>(domain, HttpStatus.CREATED);
    }

}
