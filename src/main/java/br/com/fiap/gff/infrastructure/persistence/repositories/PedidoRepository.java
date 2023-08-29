package br.com.fiap.gff.infrastructure.persistence.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fiap.gff.infrastructure.persistence.entities.PedidoEntity;

public interface PedidoRepository extends MongoRepository<PedidoEntity, String> {
}
