package com.lyschev.bdlab.repositoryies;

import com.lyschev.bdlab.models.ClubEntity;
import com.lyschev.bdlab.models.PlayerEntity;
import com.lyschev.bdlab.models.TeamEntity;
import com.lyschev.bdlab.models.TeamMainEntity;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional
class TeamRepositoryTest {

    @Autowired
    private TeamRepository teamRepository;


    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private TeamMainRepository teamMainRepository;

    @Order(1)
    @Test
    public void addTeamTest(){
        String clubName = "Manchester Utd";
        TeamEntity team = new TeamEntity();

        team.setCaptain(1);
        Optional<ClubEntity> clubEntityOptional = clubRepository.findById(clubName);
        team.setClub(clubEntityOptional.orElse(null));
        team = teamRepository.save(team);

        assert(team.getId() > 0);
    }

    @Order(2)
    @Test
    public void addTeamAndMainEntities(){
        String clubName = "Manchester Utd";

        TeamEntity team = new TeamEntity();

        team.setCaptain(1);
        Optional<ClubEntity> clubEntityOptional = clubRepository.findById(clubName);
        team.setClub(clubEntityOptional.orElse(null));
        team = teamRepository.save(team);

        Set<PlayerEntity> playerEntityList = playerRepository.findAllByClubName(clubName);

        Iterable<TeamEntity> teamEntities = teamRepository.findAll();
        teamEntities.forEach(teamEntity -> System.out.println(teamEntity.getId()));

        System.out.println(team.getId());
        TeamEntity finalTeam = team;
        Set<TeamMainEntity> teamsMainEntities = playerEntityList.stream().limit(11).map((playerEntity -> {
            TeamMainEntity teamMainEntity = new TeamMainEntity();
            teamMainEntity.setTeam(finalTeam);
            teamMainEntity.setPlayer(playerEntity);
            return teamMainEntity;
        })).collect(Collectors.toSet());
        teamMainRepository.saveAll(teamsMainEntities);

    }


    @Test
    @Order(3)
    public void addFullTeamTest(){
        String clubName = "Manchester Utd";

        TeamEntity team = new TeamEntity();

        team.setCaptain(1);
        Optional<ClubEntity> clubEntityOptional = clubRepository.findById(clubName);
        team.setClub(clubEntityOptional.orElse(null));

        Set<PlayerEntity> playerEntityList = playerRepository.findAllByClubName(clubName);

        Iterable<TeamEntity> teamEntities = teamRepository.findAll();
        teamEntities.forEach(teamEntity -> System.out.println(teamEntity.getId()));

        System.out.println(team.getId());
        Set<TeamMainEntity> teamsMainEntities = playerEntityList.stream().limit(11).map((playerEntity -> {
            TeamMainEntity teamMainEntity = new TeamMainEntity();
            teamMainEntity.setTeam(team);
            teamMainEntity.setPlayer(playerEntity);
            return teamMainEntity;
        })).collect(Collectors.toSet());

        team.setTeamsMainEntities(teamsMainEntities);
        teamRepository.save(team);
    }
}