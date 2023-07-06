package br.com.fiap.gff.infrastructure.adapters.output.persistence.repository;

import br.com.fiap.gff.infrastructure.adapters.output.persistence.entity.CategoriaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface CategoriaRepository extends MongoRepository<CategoriaEntity, String> {
    Optional<CategoriaEntity> findByCodigo(Integer codigo);
    boolean existsCategoriaEntityByCodigo(Integer codigo);
    Optional<CategoriaEntity> findFirstByOrderByCodigoDesc();
    void deleteByCodigo(Integer codigo);
}
