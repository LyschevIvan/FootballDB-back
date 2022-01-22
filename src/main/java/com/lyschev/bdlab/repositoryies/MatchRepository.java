package com.lyschev.bdlab.repositoryies;

import com.lyschev.bdlab.models.MatchEntity;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<MatchEntity, String> {
}
