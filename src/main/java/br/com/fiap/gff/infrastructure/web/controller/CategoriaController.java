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

import br.com.fiap.gff.domain.model.entities.Categoria;
import br.com.fiap.gff.domain.usecase.CategoriaUseCase;
import br.com.fiap.gff.infrastructure.web.dto.request.CreateCategoriaRequest;
import br.com.fiap.gff.infrastructure.web.dto.request.UpdateCategoriaRequest;
import br.com.fiap.gff.infrastructure.web.mapper.CategoriaRestMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1")
@Tag(name = "categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaUseCase useCase;
    private final CategoriaRestMapper mapper;

    @Operation(summary = "Retorna todas as categorias do banco de dados.")
    @GetMapping(value = "/categoria")
    public ResponseEntity<Collection<Categoria>> obterTodasCategorias() {
        var categorias = useCase.obterTodasCategorias();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    @Operation(summary = "Retorna uma categoria do banco de dados pelo código informado.")
    @GetMapping(value = "/categoria/codigo/{codigo}")
    public ResponseEntity<Categoria> obterCategoriaPeloCodigo(@PathVariable Integer codigo) {
        var categoria = useCase.obterCategoriaPorCodigo(codigo);
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }

    @Operation(summary = "Retorna uma cateogoria do banco de dados pelo id informado.")
    @GetMapping(value = "/categoria/id/{id}")
    public ResponseEntity<Categoria> obterCategoriaPeloId(@PathVariable String id) {
        var categoria = useCase.obterCategoriaPorId(id);
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }

    @Operation(summary = "Cria uma categoria a partir do contrato abaixo.")
    @PostMapping(value = "/categoria")
    public ResponseEntity<Categoria> criarCategoria(@RequestBody CreateCategoriaRequest request) {
        var categoria = mapper.toModel(request);
        categoria = useCase.criarCategoria(categoria);
        return new ResponseEntity<>(categoria, HttpStatus.CREATED);
    }

    @Operation(summary = "Atualiza uma categoria a partir das informações abaixo.")
    @PutMapping(value = "/categoria/{id}")
    public ResponseEntity<Categoria> atualizarCategoria(@PathVariable String id,
            @RequestBody UpdateCategoriaRequest request) {
        var categoria = mapper.toModel(request);
        categoria.setId(id);
        categoria = useCase.atualizarCategoria(categoria);
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }

    @Operation(summary = "Apaga uma categoria pelo id informado.")
    @DeleteMapping(value = "/categoria/deletar/id/{id}")
    public ResponseEntity<String> deletarCategoriaPorId(@PathVariable String id) {
        useCase.deletarCategoriaPorId(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @Operation(summary = "Apaga uma categoria pelo código informado.")
    @DeleteMapping(value = "/categoria/deletar/codigo/{codigo}")
    public ResponseEntity<Integer> deletarCategoriaPeloCodigo(@PathVariable Integer codigo) {
        useCase.deletarCategoriaPorCodigo(codigo);
        return new ResponseEntity<>(codigo, HttpStatus.OK);
    }
}
