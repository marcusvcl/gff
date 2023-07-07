package br.com.fiap.gff.infrastructure.adapters.output.persistence.repositories;

import br.com.fiap.gff.infrastructure.adapters.output.persistence.entities.ProdutoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends MongoRepository<ProdutoEntity, String> {
    @Query("{ 'categoria.codigo': ?0 }")
    Optional<Collection<ProdutoEntity>> findByCategoriaCodigo(Integer codigoCategoria);
}
