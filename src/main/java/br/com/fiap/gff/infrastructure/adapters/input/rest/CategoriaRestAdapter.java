package br.com.fiap.gff.infrastructure.adapters.input.rest;

import br.com.fiap.gff.application.ports.input.CategoriaUseCase;
import br.com.fiap.gff.domain.models.Categoria;
import br.com.fiap.gff.infrastructure.adapters.input.rest.data.request.CreateCategoriaRequest;
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
        Collection<Categoria> categorias = useCase.obterTodasCategorias();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    @Operation(summary = "Retorna uma categoria do banco de dados pelo código informado.")
    @GetMapping(value = "/categoria/codigo/{codigo}")
    public ResponseEntity<Categoria> obterCategoriaPeloCodigo(@PathVariable Integer codigo) {
        Categoria categoria = useCase.obterCategoriaPorCodigo(codigo);
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }


    @Operation(summary = "Retorna uma cateogoria do banco de dados pelo id informado.")
    @GetMapping(value = "/categoria/id/{id}")
    public ResponseEntity<Categoria> obterCategoriaPeloId(@PathVariable String id) {
        Categoria categoria = useCase.obterCategoriaPorId(id);
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }

    @Operation(summary = "Cria uma categoria a partir do contrato abaixo.")
    @PostMapping(value = "/categoria")
    public ResponseEntity<Categoria> criarCategoria(@RequestBody CreateCategoriaRequest request) {
        Categoria categoria = mapper.toDomain(request);
        categoria = useCase.criarCategoria(categoria);
        return new ResponseEntity<>(categoria, HttpStatus.CREATED);
    }
}
