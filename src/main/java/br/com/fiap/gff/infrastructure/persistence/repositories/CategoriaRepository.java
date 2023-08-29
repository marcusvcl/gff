package br.com.fiap.gff.infrastructure.persistence.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fiap.gff.infrastructure.persistence.entities.CategoriaEntity;

import java.util.Optional;

public interface CategoriaRepository extends MongoRepository<CategoriaEntity, String> {
    Optional<CategoriaEntity> findByCodigo(Integer codigo);
    boolean existsCategoriaEntityByCodigo(Integer codigo);
    Optional<CategoriaEntity> findFirstByOrderByCodigoDesc();
    void deleteByCodigo(Integer codigo);
}
