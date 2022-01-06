package com.lyschev.bdlab.repositoryies;

import com.lyschev.bdlab.models.ClubEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
class ClubRepositoryTest {

    @Autowired
    ClubRepository clubRepository;

    @Test
    @Transactional
    public void test(){
        for (ClubEntity clubEntity : clubRepository.findAll()) {
            System.out.println(clubEntity);
        }
    }
}