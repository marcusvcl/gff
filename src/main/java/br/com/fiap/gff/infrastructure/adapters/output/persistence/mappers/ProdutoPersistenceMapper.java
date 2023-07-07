package br.com.fiap.gff.infrastructure.adapters.output.persistence.mappers;

import br.com.fiap.gff.domain.models.Produto;
import br.com.fiap.gff.infrastructure.adapters.output.persistence.entities.ProdutoEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ProdutoPersistenceMapper {
    Produto toModel(ProdutoEntity entity);
    ProdutoEntity toEntity(Produto model);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromModel(Produto model, @MappingTarget ProdutoEntity entity);
}
