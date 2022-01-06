package com.lyschev.bdlab.mappers;

import com.lyschev.bdlab.dto.Dto;
import com.lyschev.bdlab.models.EntityInterface;

public interface Mapper <E extends EntityInterface, D extends Dto>{
    E toEntity(D dto);
    D toDto(E entity);
}
