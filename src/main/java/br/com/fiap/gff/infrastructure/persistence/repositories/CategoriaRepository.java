package br.com.fiap.gff.infrastructure.persistence.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fiap.gff.infrastructure.persistence.entities.CategoriaEntity;

public interface CategoriaRepository extends MongoRepository<CategoriaEntity, String> {
    Optional<CategoriaEntity> findByCodigo(Integer codigo);

    boolean existsCategoriaEntityByCodigo(Integer codigo);

    Optional<CategoriaEntity> findFirstByOrderByCodigoDesc();

    void deleteByCodigo(Integer codigo);
}
