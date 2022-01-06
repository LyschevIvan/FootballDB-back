package com.lyschev.bdlab.repositoryies;

import com.lyschev.bdlab.models.ClubEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClubRepository extends CrudRepository<ClubEntity, String> {

}
