package br.com.fiap.gff.infrastructure.persistence.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fiap.gff.infrastructure.persistence.entities.ClienteEntity;

public interface ClienteRepository extends MongoRepository<ClienteEntity, String> {
}
