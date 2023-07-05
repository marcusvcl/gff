package br.com.fiap.gff.infrastructure.adapters.output.persistence.repository;

import br.com.fiap.gff.infrastructure.adapters.output.persistence.entity.ProdutoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends MongoRepository<ProdutoEntity, String> {
    Optional<Collection<ProdutoEntity>> findByCodigoCategoria(Integer codigoCategoria);
}
