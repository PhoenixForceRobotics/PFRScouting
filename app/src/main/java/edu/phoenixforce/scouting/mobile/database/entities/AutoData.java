package edu.phoenixforce.scouting.mobile.database.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class AutoData  {


    public String getMissed() {
        return missed;
    }

    public void setMissed(String missed) {
        this.missed = missed;
    }

    public String getScoutName() {
        return scoutName;
    }

    public void setScoutName(String scoutName) {
        this.scoutName = scoutName;
    }



    public String getMatchNum() {
        return matchNum;
    }

    public void setMatchNum(String matchNum) {
        this.matchNum = matchNum;
    }

    public int getTeamNum() {
        return teamNum;
    }

    public void setTeamNum(int teamNum) {
        this.teamNum = teamNum;
    }

    public AutoData(String moved, String lowBall, String midBall, String highBall, String ballsIntook, String missed,
                    String scoutName, String matchNum, int teamNum) {

        this.moved = moved;
        this.lowBall = lowBall;
        this.midBall = midBall;
        this.highBall = highBall;
        this.ballsIntook = ballsIntook;
        this.missed = missed;
        this.scoutName = scoutName;
        this.matchNum = matchNum;
        this.teamNum = teamNum;

    }



    @ColumnInfo(name = "moved")
    private String moved;

    @ColumnInfo(name = "lowBall")
    private String lowBall;

    @ColumnInfo(name = "midBall")
    private String midBall;

    @ColumnInfo (name = "highBall")
    private String highBall;

    @ColumnInfo(name = "ballsIntook")
    private String ballsIntook;

    @ColumnInfo(name = "missed")
    private String missed;

    @ColumnInfo(name = "scout")
    private String scoutName;


    @ColumnInfo(name = "MatchNum")
    private String matchNum;

    @PrimaryKey(autoGenerate = true)
    @NonNull

    @ColumnInfo(name = "TeamNum")
    private int teamNum;




    public String getMoved() {
        return moved;
    }

    public void setMoved(String moved) {
        this.moved = moved;
    }

    public String getLowBall() {
        return lowBall;
    }

    public void setLowBall(String lowBall) {
        this.lowBall = lowBall;
    }

    public String getMidBall() {
        return midBall;
    }

    public void setMidBall(String midBall) {
        this.midBall = midBall;
    }

    public String getHighBall() {
        return highBall;
    }


    public String getBallsIntook() {
        return ballsIntook;
    }

    public void setBallsIntook(String ballsIntook) {
        this.ballsIntook = ballsIntook;
    }
}
