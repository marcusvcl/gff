package br.com.fiap.gff.infrastructure.persistence.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fiap.gff.infrastructure.persistence.entities.PagamentoEntity;

public interface PagamentoRepository extends MongoRepository<PagamentoEntity, String> {
    Optional<PagamentoEntity> findByTransacaoId(String transacaoId);
}
