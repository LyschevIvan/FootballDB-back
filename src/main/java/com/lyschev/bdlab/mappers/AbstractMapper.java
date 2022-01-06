package com.lyschev.bdlab.mappers;


import com.lyschev.bdlab.dto.Dto;
import com.lyschev.bdlab.models.EntityInterface;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public abstract class AbstractMapper<E extends EntityInterface, D extends Dto> implements Mapper<E,D> {

    @Autowired
    private ModelMapper modelMapper;

    private final Class<E> entityClass;
    private final Class<D> dtoClass;

    public AbstractMapper(Class<E> entityClass, Class<D> dtoClass) {
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }


    @Override
    public E toEntity(D dto) {
        return Objects.isNull(dto) ? null: modelMapper.map(dto, entityClass);
    }

    @Override
    public D toDto(E entity) {
        return Objects.isNull(entity) ? null: modelMapper.map(entity, dtoClass);
    }

    Converter<E, D> toDtoConverter(){
        return mappingContext -> {
            E source = mappingContext.getSource();
            D destination = mappingContext.getDestination();
            mapSpecificFields(source, destination);
            return mappingContext.getDestination();
        };
    }

    Converter<D, E> toEntityConverter(){
        return mappingContext -> {
            D source = mappingContext.getSource();
            E destination = mappingContext.getDestination();
            mapSpecificFields(source, destination);
            return mappingContext.getDestination();
        };
    }
    void mapSpecificFields(D source, E destination){

    }

    void mapSpecificFields(E source, D destination){

    }
}
