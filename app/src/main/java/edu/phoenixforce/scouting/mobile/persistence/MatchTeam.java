package edu.phoenixforce.scouting.mobile.persistence;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName = "match_team")
public class MatchTeam {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "match_team_id")
    private UUID matchTeamId = UUID.randomUUID();

    @NonNull
    @ColumnInfo(name = "match_id")
    private UUID matchId;

    @NonNull
    @ColumnInfo(name = "match_team_color")
    private MatchTeamColor teamColor;

    @ColumnInfo(name = "team1_robot_id")
    private int team1RobotId;

    @ColumnInfo(name = "team2_robot_id")
    private int team2RobotId;

    @ColumnInfo(name = "team3_robot_id")
    private int team3RobotId;


    MatchTeam(@NonNull UUID matchId, @NonNull MatchTeamColor color) {
        this.matchId = matchId;
        this.teamColor = color;
    }

    @NonNull
    public UUID getMatchTeamId() {
        return matchTeamId;
    }

    @NonNull
    public UUID getMatchId() {
        return matchId;
    }

    @NonNull
    public MatchTeamColor getTeamColor() {
        return teamColor;
    }

    public int getTeam1RobotId() {
        return team1RobotId;
    }

    public void setTeam1RobotId(int team1RobotId) {
        this.team1RobotId = team1RobotId;
    }

    public int getTeam2RobotId() {
        return team2RobotId;
    }

    public void setTeam2RobotId(int team2RobotId) {
        this.team2RobotId = team2RobotId;
    }

    public int getTeam3RobotId() {
        return team3RobotId;
    }

    public void setTeam3RobotId(int team3RobotId) {
        this.team3RobotId = team3RobotId;
    }
}
