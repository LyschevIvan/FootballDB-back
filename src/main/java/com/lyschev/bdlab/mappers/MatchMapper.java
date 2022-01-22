package com.lyschev.bdlab.mappers;

import com.lyschev.bdlab.dto.MatchDto;
import com.lyschev.bdlab.models.MatchEntity;
import com.lyschev.bdlab.repositoryies.LeagueRepository;
import com.lyschev.bdlab.repositoryies.TeamRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MatchMapper extends AbstractMapper<MatchEntity, MatchDto>{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    LeagueRepository leagueRepository;

    public MatchMapper() {
        super(MatchEntity.class, MatchDto.class);
    }

    @PostConstruct
    public void setupMapper(){
        modelMapper.createTypeMap(MatchEntity.class, MatchDto.class)
                .addMappings(m -> m.skip(MatchDto::setLeague_name))
                .addMappings(m -> m.skip(MatchDto::setTeam1_id))
                .addMappings(m -> m.skip(MatchDto::setTeam2_id))
                .setPostConverter(toDtoConverter());
        modelMapper.createTypeMap(MatchDto.class, MatchEntity.class)
                .addMappings(m ->m.skip(MatchEntity::setLeague))
                .addMappings(m ->m.skip(MatchEntity::setTeam1))
                .addMappings(m ->m.skip(MatchEntity::setTeam2))
                .setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFields(MatchDto source, MatchEntity destination) {

        destination.setLeague(leagueRepository.findById(source.getLeague_name()).orElse(null));
        destination.setTeam1(teamRepository.findById(source.getTeam1_id()).orElse(null));
        destination.setTeam2(teamRepository.findById(source.getTeam2_id()).orElse(null));
    }

    @Override
    void mapSpecificFields(MatchEntity source, MatchDto destination) {
        destination.setLeague_name(source.getLeague().getName());
        destination.setTeam1_id(source.getTeam1().getId());
        destination.setTeam2_id(source.getTeam2().getId());

    }
}
