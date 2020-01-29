package edu.phoenixforce.scouting.mobile.persistence;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Calendar;
import java.util.UUID;

@Entity(tableName = "match")
public class Match {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "match_id")
    private UUID matchId = UUID.randomUUID();

    @ColumnInfo(name = "scorer")
    private String scorer = new String();

    @ColumnInfo(name = "device_num")
    private int deviceNum;

    @ColumnInfo(name = "match_num")
    private int matchNum;

    @ColumnInfo(name = "match_date")
    private Calendar matchDate;

    @ColumnInfo(name = "match_team_red")
    private MatchTeam redTeam = new MatchTeam(matchId, MatchTeamColor.RED);

    @ColumnInfo(name = "match_team_blue")
    private MatchTeam blueTeam = new MatchTeam(matchId, MatchTeamColor.BLUE);

}
