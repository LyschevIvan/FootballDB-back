package com.lyschev.bdlab.mappers;

import com.lyschev.bdlab.dto.ClubDto;
import com.lyschev.bdlab.models.ClubEntity;
import com.lyschev.bdlab.repositoryies.CoachRepository;
import com.lyschev.bdlab.repositoryies.LeagueRepository;
import com.lyschev.bdlab.repositoryies.OwnerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ClubMapper extends AbstractMapper<ClubEntity, ClubDto>{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CoachRepository coachRepository;

    @Autowired
    private LeagueRepository leagueRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    public ClubMapper() {
        super(ClubEntity.class, ClubDto.class);
    }
    @PostConstruct
    private void setupMapper(){
        modelMapper.createTypeMap(ClubEntity.class, ClubDto.class)
                .addMappings(m -> m.skip(ClubDto::setCoachName))
                .addMappings(m -> m.skip(ClubDto::setLeagueName))
                .addMappings(m -> m.skip(ClubDto::setOwnerName))
                .setPostConverter(toDtoConverter());
        modelMapper.createTypeMap(ClubDto.class, ClubEntity.class)
                .addMappings(m -> m.skip(ClubEntity::setCoachName))
                .addMappings(m -> m.skip(ClubEntity::setLeagueName))
                .addMappings(m -> m.skip(ClubEntity::setOwnerName))
                .setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFields(ClubDto source, ClubEntity destination) {

        destination.setCoachName(coachRepository.findById(source.getCoachName()).orElse(null));
        destination.setLeagueName(leagueRepository.findById(source.getLeagueName()).orElse(null));
        destination.setOwnerName(ownerRepository.findById(source.getOwnerName()).orElse(null));
    }

    @Override
    void mapSpecificFields(ClubEntity source, ClubDto destination) {
        destination.setCoachName(source.getCoachName().getName());
        destination.setLeagueName(source.getLeagueName().getName());
        destination.setOwnerName(source.getOwnerName().getName());

    }
}
