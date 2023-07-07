package br.com.fiap.gff.infrastructure.adapters.output.persistence.mappers;

import br.com.fiap.gff.domain.models.Pagamento;
import br.com.fiap.gff.infrastructure.adapters.output.persistence.entities.PagamentoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PagamentoPersistenceMapper {

    PagamentoEntity toEntity(Pagamento model);

    Pagamento toModel(PagamentoEntity entity);
}
