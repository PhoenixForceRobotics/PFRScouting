package edu.phoenixforce.scouting.mobile.database.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Team {



    public Team(String teamNum, String matchNum){
        this.teamNum = teamNum;
        this.matchNum = matchNum;


    }

    @PrimaryKey
    @NonNull

    @ColumnInfo(name = "team_Num")
    private String teamNum;

    @ColumnInfo(name = "match_Num")
    private String matchNum;


    public String getTeamNum() {
        return teamNum;
    }

    public void setTeamNum(String teamNum) {
        this.teamNum = teamNum;
    }

    public String getMatchNum() {
        return matchNum;
    }

    public void setMatchNum(String matchNum) {
        this.matchNum = matchNum;
    }
}

