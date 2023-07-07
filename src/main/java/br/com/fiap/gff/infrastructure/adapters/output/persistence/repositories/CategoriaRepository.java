package br.com.fiap.gff.infrastructure.adapters.output.persistence.repositories;

import br.com.fiap.gff.infrastructure.adapters.output.persistence.entities.CategoriaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CategoriaRepository extends MongoRepository<CategoriaEntity, String> {
    Optional<CategoriaEntity> findByCodigo(Integer codigo);
    boolean existsCategoriaEntityByCodigo(Integer codigo);
    Optional<CategoriaEntity> findFirstByOrderByCodigoDesc();
    void deleteByCodigo(Integer codigo);
}
