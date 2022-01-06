package com.lyschev.bdlab.mappers;

import com.lyschev.bdlab.dto.TeamMainDto;
import com.lyschev.bdlab.models.TeamMainEntity;
import com.lyschev.bdlab.repositoryies.PlayerRepository;
import com.lyschev.bdlab.repositoryies.TeamRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TeamMainMapper extends AbstractMapper<TeamMainEntity, TeamMainDto>{
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PlayerRepository playerRepository;


    @Autowired
    private TeamRepository teamRepository;


    public TeamMainMapper() {
        super(TeamMainEntity.class, TeamMainDto.class);
    }

    @PostConstruct
    private void setupMapper(){
        modelMapper.createTypeMap(TeamMainEntity.class, TeamMainDto.class)
                .addMappings(m -> m.skip(TeamMainDto::setTeamId))
                .setPostConverter(toDtoConverter());
        modelMapper.createTypeMap(TeamMainDto.class, TeamMainEntity.class)
                .addMappings(m -> m.skip(TeamMainEntity::setTeam))
                .setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFields(TeamMainDto source, TeamMainEntity destination) {
        destination.setTeam(teamRepository.findById(source.getTeamId()).orElse(null));
        destination.setPlayer(playerRepository.findById(source.getPlayerId()).orElse(null));
    }

    @Override
    void mapSpecificFields(TeamMainEntity source, TeamMainDto destination) {
        destination.setPlayerId(source.getPlayer().getId());
        destination.setTeamId(source.getTeam().getId());
    }
}
