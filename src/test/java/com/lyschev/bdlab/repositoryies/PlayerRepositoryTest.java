package com.lyschev.bdlab.repositoryies;

import com.lyschev.bdlab.models.PlayerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlayerRepositoryTest {

    @Autowired
    PlayerRepository playerRepository;

    @Test
    void findAllByClubTest() {
        for (PlayerEntity playerEntity : playerRepository.findAllByClubName("Manchester Utd")) {
            System.out.println(playerEntity.toString());
        }


    }
}