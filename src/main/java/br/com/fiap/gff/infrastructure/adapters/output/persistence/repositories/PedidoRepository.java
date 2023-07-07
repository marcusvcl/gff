package br.com.fiap.gff.infrastructure.adapters.output.persistence.repositories;

import br.com.fiap.gff.infrastructure.adapters.output.persistence.entities.PedidoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidoRepository extends MongoRepository<PedidoEntity, String> {
}
