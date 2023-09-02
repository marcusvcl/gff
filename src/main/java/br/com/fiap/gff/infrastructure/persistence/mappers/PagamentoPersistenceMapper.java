package br.com.fiap.gff.infrastructure.persistence.mappers;

import org.mapstruct.Mapper;

import br.com.fiap.gff.domain.model.entities.Pagamento;
import br.com.fiap.gff.infrastructure.persistence.entities.PagamentoEntity;

@Mapper(componentModel = "spring")
public interface PagamentoPersistenceMapper {

    PagamentoEntity toEntity(Pagamento model);

    Pagamento toModel(PagamentoEntity entity);
}
