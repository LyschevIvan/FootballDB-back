package com.lyschev.bdlab.mappers;

import com.lyschev.bdlab.dto.TeamMainDto;
import com.lyschev.bdlab.dto.TeamMainPlayerDto;
import com.lyschev.bdlab.mappers.Wrappers.TeamMainEntityWrapper;
import com.lyschev.bdlab.models.TeamEntity;
import com.lyschev.bdlab.models.TeamMainEntity;
import com.lyschev.bdlab.repositoryies.PlayerRepository;
import com.lyschev.bdlab.repositoryies.TeamRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeamMainMapper extends AbstractMapper<TeamMainEntityWrapper, TeamMainDto>{
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PlayerRepository playerRepository;


    @Autowired
    private TeamRepository teamRepository;


    public TeamMainMapper() {
        super(TeamMainEntityWrapper.class, TeamMainDto.class);
    }

    @PostConstruct
    private void setupMapper(){
        modelMapper.createTypeMap(TeamMainEntityWrapper.class, TeamMainDto.class)
                .addMappings(m -> m.skip(TeamMainDto::setTeamId))
                .addMappings(m -> m.skip(TeamMainDto::setTeamMainPlayerDtos))
                .setPostConverter(toDtoConverter());
        modelMapper.createTypeMap(TeamMainDto.class, TeamMainEntityWrapper.class)
                .addMappings(m -> m.skip(TeamMainEntityWrapper::setTeamMainEntities))
                .setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFields(TeamMainDto source, TeamMainEntityWrapper destination) {
        ArrayList<TeamMainEntity> teamMainEntities;
        TeamEntity team = teamRepository.findById(source.getTeamId()).orElse(null);
        teamMainEntities = source.getTeamMainPlayerDtos().stream().map(dto ->{
            TeamMainEntity teamMainEntity = new TeamMainEntity();
            teamMainEntity.setId(dto.getPlayerId());
            teamMainEntity.setTeam(team);
            teamMainEntity.setPlayer(playerRepository.findById(dto.getPlayerId()).orElse(null));
            return teamMainEntity;
        }).collect(Collectors.toCollection(ArrayList::new));
        destination.setTeamMainEntities(teamMainEntities);
    }

    @Override
    void mapSpecificFields(TeamMainEntityWrapper source, TeamMainDto destination) {
        if(!source.getTeamMainEntities().isEmpty()){
            destination.setTeamId(source.getTeamMainEntities().get(0).getTeam().getId());
            ArrayList<TeamMainPlayerDto> teamMainPlayerDtos = source.getTeamMainEntities().stream()
                    .map(teamMainEntity -> {
                        TeamMainPlayerDto playerDto = new TeamMainPlayerDto();
                        playerDto.setPlayerId(teamMainEntity.getPlayer().getId());
                        playerDto.setId(teamMainEntity.getId());
                        return playerDto;
                    }).collect(Collectors.toCollection(ArrayList::new));
            destination.setTeamMainPlayerDtos(teamMainPlayerDtos);
        }


    }
}
