package edu.phoenixforce.scouting.mobile.database.entities;

import android.service.autofill.FieldClassification;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

//2022 Game Table

@Entity
public class GameData{

    //Create the variable for the columns in the table
    public GameData(@NotNull String Scout,String DevNum, String MatchNum, String TeamNum, String Moved, String Stalled, String ClimbLevel,
                     String BallLow, String BallHigh, String AutoBallLow,
                    String AutoBallHigh, String CycleAttempted, String Dropped, String Missed) {
    //Create our getters and setters - will we ever use them tho???


        this.MatchNum = MatchNum;
        this.TeamNum = TeamNum;
        this.Moved = Moved;
        this.Stalled = Stalled;
        this.ClimbLevel = ClimbLevel;
        this.CycleAttempted = CycleAttempted;
        this.Dropped = Dropped;
        this.Missed = Missed;
        this.BallLow = BallLow;
        this.BallHigh = BallHigh;
        this.AutoBallHigh = AutoBallHigh;
        this.AutoBallLow = AutoBallLow;
        this.DevNum = DevNum;
        this.Scout = Scout;
    }

    public String getScout() {
        return Scout;
    }

    public void setScout(String scout) {
        Scout = scout;
    }

    public String getMatchNum() {
        return MatchNum;
    }

    public void setMatchNum(String matchNum) {
        MatchNum = matchNum;
    }

    public String getTeamNum() {
        return TeamNum;
    }

    public void setTeamNum(String teamNum) {
        TeamNum = teamNum;
    }

    public String getMoved() {
        return Moved;
    }

    public void setMoved(String moved) {
        Moved = moved;
    }

    public String getStalled() {
        return Stalled;
    }

    public void setStalled(String stalled) {
        Stalled = stalled;
    }

    public String getClimbLevel() {
        return ClimbLevel;
    }




    public String getBallLow() {
        return BallLow;
    }

    public void setBallLow(String ballLow) {
        BallLow = ballLow;
    }

    public String getBallHigh() {
        return BallHigh;
    }

    public void setBallHigh(String ballHigh) {
        BallHigh = ballHigh;
    }

    public String getAutoBallLow() {
        return AutoBallLow;
    }

    public void setAutoBallLow(String autoBallLow) {
        AutoBallLow = autoBallLow;
    }

    public String getAutoBallHigh() {
        return AutoBallHigh;
    }

    public void setAutoBallHigh(String autoBallHigh) {
        AutoBallHigh = autoBallHigh;
    }

    public String getDevNum() {
        return DevNum;
    }

    public void setDevNum(String devNum) {
        DevNum = devNum;
    }

    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "MatchNum")
    private String MatchNum;

    @ColumnInfo(name = "Scout")
    private String Scout;

    @ColumnInfo(name = "TeamNum")
    private String TeamNum;

    @ColumnInfo(name = "Moved")
    private String Moved;

    @ColumnInfo(name = "Stalled")
    private String Stalled;

    @ColumnInfo(name = "ClimbLevel")
    private String ClimbLevel;



    @ColumnInfo(name = "BalLLow")
    private String BallLow;

    @ColumnInfo(name = "BallHigh")
    private String BallHigh;

    @ColumnInfo(name = "AutpBalLLow")
    private String AutoBallLow;

    @ColumnInfo(name = "AutoBallHigh")
    private String AutoBallHigh;

    @ColumnInfo(name = "DevNum")
    private String DevNum;

    public String getCycleAttempted() {
        return CycleAttempted;
    }

    public void setCycleAttempted(String cycleAttempted) {
        CycleAttempted = cycleAttempted;
    }

    @ColumnInfo(name = "CycleAttempted")
    private String CycleAttempted;

    @ColumnInfo(name = "Dropped")
    private String Dropped;

    public String getDropped() {
        return Dropped;
    }



    public String getMissed() {
        return Missed;
    }

    public void setMissed(String missed) {
        Missed = missed;
    }

    @ColumnInfo(name = "Missed")
    private String Missed;
}
