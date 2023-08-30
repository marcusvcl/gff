package br.com.fiap.gff.infrastructure.persistence.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import br.com.fiap.gff.domain.model.entities.Produto;
import br.com.fiap.gff.infrastructure.persistence.entities.ProdutoEntity;

@Mapper(componentModel = "spring")
public interface ProdutoPersistenceMapper {
    Produto toModel(ProdutoEntity entity);

    ProdutoEntity toEntity(Produto model);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromModel(Produto model, @MappingTarget ProdutoEntity entity);
}
