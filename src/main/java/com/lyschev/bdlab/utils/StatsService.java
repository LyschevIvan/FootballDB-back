package com.lyschev.bdlab.utils;


import com.lyschev.bdlab.models.PlayerEntity;
import com.lyschev.bdlab.models.TeamEntity;
import com.lyschev.bdlab.models.TeamMainEntity;
import org.springframework.stereotype.Service;

import java.util.Set;


public class StatsService {
    public static int getStats(TeamEntity team){
        int stat = 0;
        Set<TeamMainEntity> teamMainEntities = team.getTeamsMainEntities();
        if (teamMainEntities!=null) {
            for (TeamMainEntity mainEntity : teamMainEntities) {
                PlayerEntity playerEntity = mainEntity.getPlayer();
                int playerStat = 0;
                playerStat += playerEntity.getPace();
                playerStat += playerEntity.getDefending();
                playerStat += playerEntity.getDribbling();
                playerStat += playerEntity.getPass();
                playerStat += playerEntity.getPhysicality();
                playerStat += playerEntity.getShooting();
                stat += playerStat;
            }

        }
        return stat;
    }

    public static Float getProbability(TeamEntity team1, TeamEntity team2) {
        float stat1 = (float) getStats(team1);
        int stat2 = getStats(team2);
        if (stat1 == 0f || stat2 == 0) return null;
        return stat1/(stat1+stat2);
    }
}
