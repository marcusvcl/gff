package br.com.fiap.gff.infrastructure.adapters.output.persistence.repositories;

import br.com.fiap.gff.infrastructure.adapters.output.persistence.entities.ClienteEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<ClienteEntity, String> {
}
