package com.lyschev.bdlab.repositoryies;

import com.lyschev.bdlab.models.LeagueEntity;
import org.springframework.data.repository.CrudRepository;

public interface LeagueRepository extends CrudRepository<LeagueEntity, String> {
}
