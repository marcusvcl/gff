package br.com.fiap.gff.infrastructure.adapters.input.rest;

import br.com.fiap.gff.application.ports.input.ProdutoUseCase;
import br.com.fiap.gff.domain.model.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ProdutoRestAdapter {

    private final ProdutoUseCase useCase;

    @PostMapping(value = "/produtos")
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto)
    {
        produto = useCase.criarProduto(produto);
        return new ResponseEntity<>(produto, HttpStatus.CREATED);
    }

    @GetMapping(value = "/produtos")
    public ResponseEntity<Collection<Produto>> obterTodosProdutos() {
        Collection<Produto> produtos = useCase.obterTodosProdutos();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping(value = "/produtos/categoria/{codigoCategoria}")
    public ResponseEntity<Collection<Produto>> obterProdutoPorCategoria(@PathVariable Integer codigoCategoria) {
        Collection<Produto> produtos = useCase.obterProdutoPorCategoria(codigoCategoria);
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }
}
