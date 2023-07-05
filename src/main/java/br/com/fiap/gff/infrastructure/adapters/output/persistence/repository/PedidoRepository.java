package br.com.fiap.gff.infrastructure.adapters.output.persistence.repository;

import br.com.fiap.gff.infrastructure.adapters.output.persistence.entity.PedidoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidoRepository extends MongoRepository<PedidoEntity, String> {
}
