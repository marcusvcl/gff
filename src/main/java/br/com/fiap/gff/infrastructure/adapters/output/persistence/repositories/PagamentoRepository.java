package br.com.fiap.gff.infrastructure.adapters.output.persistence.repositories;

import br.com.fiap.gff.infrastructure.adapters.output.persistence.entities.PagamentoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PagamentoRepository extends MongoRepository<PagamentoEntity, String> {
    Optional<PagamentoEntity> findByTransacaoId(String transacaoId);
}
