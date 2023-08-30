package br.com.fiap.gff.application.web.controller;

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

import br.com.fiap.gff.application.web.dto.request.CreateProdutoRequest;
import br.com.fiap.gff.application.web.dto.request.UpdateProdutoRequest;
import br.com.fiap.gff.application.web.mapper.ProdutoRestMapper;
import br.com.fiap.gff.domain.model.entities.Produto;
import br.com.fiap.gff.domain.usecase.ProdutoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1")
@Tag(name = "produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoUseCase produtoUseCase;
    private final ProdutoRestMapper mapper;

    @GetMapping(value = "/produtos")
    @Operation(summary = "Lista todos os produtos cadastrados na base.")
    public ResponseEntity<Collection<Produto>> obterTodosProdutos() {
        Collection<Produto> produtos = produtoUseCase.obterTodosProdutos();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping(value = "/produtos/{id}")
    @Operation(summary = "Retorna um produto pelo id informado.")
    public ResponseEntity<Produto> obterProdutoPorId(@PathVariable String id) {
        var produto = produtoUseCase.obterProdutoPorId(id);
        return new ResponseEntity<>(produto, HttpStatus.OK);
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
        var produto = mapper.toModel(request);
        produto = produtoUseCase.criarProduto(produto);
        return new ResponseEntity<>(produto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/produtos/{id}")
    @Operation(summary = "Atualiza um produto a partir dos dados informados.")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable String id,
            @RequestBody UpdateProdutoRequest request) {
        var produto = mapper.toModel(request);
        produto.setId(id);
        produto = produtoUseCase.atualizarProduto(produto);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/produto/{id}")
    @Operation(summary = "Deleta um produto pelo id informado.")
    public ResponseEntity<String> deletarProdutoPeloId(@PathVariable String id) {
        produtoUseCase.deletarProdutoPorId(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
