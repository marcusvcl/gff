package br.com.fiap.gff.infrastructure.adapters.input.rest;

import br.com.fiap.gff.application.ports.input.CategoriaUseCase;
import br.com.fiap.gff.domain.model.Categoria;
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

    @GetMapping(value = "/categoria")
    public ResponseEntity<Collection<Categoria>> obterTodasCategorias() {
        Collection<Categoria> categorias = useCase.obterTodasCategorias();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    @GetMapping(value = "/categoria/codigo/{codigo}")
    public ResponseEntity<Categoria> obterCategoriaPeloCodigo(@PathVariable Integer codigo) {
        Categoria categoria = useCase.obterCategoriaPorCodigo(codigo);
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }


    @GetMapping(value = "/categoria/id/{id}")
    public ResponseEntity<Categoria> obterCategoriaPeloId(@PathVariable String id) {
        Categoria categoria = useCase.obterCategoriaPorId(id);
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }

    @PostMapping(value = "/categoria")
    public ResponseEntity<Categoria> criarCategoria(@RequestBody Categoria categoria) {
        Categoria created = useCase.criarCategoria(categoria);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
