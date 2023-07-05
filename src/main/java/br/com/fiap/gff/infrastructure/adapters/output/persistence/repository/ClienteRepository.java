package br.com.fiap.gff.infrastructure.adapters.output.persistence.repository;

import br.com.fiap.gff.infrastructure.adapters.output.persistence.entity.ClienteEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<ClienteEntity, String> {
}
