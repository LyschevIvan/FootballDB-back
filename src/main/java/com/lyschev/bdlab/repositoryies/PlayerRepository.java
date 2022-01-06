package com.lyschev.bdlab.repositoryies;

import com.lyschev.bdlab.models.PlayerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface PlayerRepository extends CrudRepository<PlayerEntity, Integer> {
    Set<PlayerEntity> findAllByClubName(String clubName);
}
