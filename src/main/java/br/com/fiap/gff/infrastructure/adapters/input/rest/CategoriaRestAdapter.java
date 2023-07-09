package br.com.fiap.gff.infrastructure.adapters.input.rest;

import br.com.fiap.gff.application.ports.input.CategoriaUseCase;
import br.com.fiap.gff.domain.models.Categoria;
import br.com.fiap.gff.infrastructure.adapters.input.rest.data.request.CreateCategoriaRequest;
import br.com.fiap.gff.infrastructure.adapters.input.rest.data.request.UpdateCategoriaRequest;
import br.com.fiap.gff.infrastructure.adapters.input.rest.mapper.CategoriaRestMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/v1")
@Tag(name = "categorias")
@RequiredArgsConstructor
public class CategoriaRestAdapter {

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
    public ResponseEntity<Categoria> atualizarCategoria(@PathVariable String id, @RequestBody UpdateCategoriaRequest request) {
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
