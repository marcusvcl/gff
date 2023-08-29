package br.com.fiap.gff.infrastructure.persistence.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fiap.gff.infrastructure.persistence.entities.PagamentoEntity;

import java.util.Optional;

public interface PagamentoRepository extends MongoRepository<PagamentoEntity, String> {
    Optional<PagamentoEntity> findByTransacaoId(String transacaoId);
}
