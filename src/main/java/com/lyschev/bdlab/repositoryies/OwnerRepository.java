package com.lyschev.bdlab.repositoryies;

import com.lyschev.bdlab.models.OwnerEntity;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<OwnerEntity, String> {
}
