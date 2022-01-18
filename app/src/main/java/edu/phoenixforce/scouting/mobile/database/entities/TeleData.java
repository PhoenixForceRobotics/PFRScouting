package edu.phoenixforce.scouting.mobile.database.entities;

import android.service.autofill.FieldClassification;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@Entity
public class TeleData{
    // apple sucks :)
    // this is the class in which we write data and save it to the database - as of right now this is the only known working entitiy
    // While in theory using different tables for different secrtions of scoring is ideal for workign with the database, in the case of this it is going to be...
    // ... in our best interest to use one so that it only has to be exported to one csv file in DBViewerforSQL


    /*@NotNull String Match, String ballLow, String ballMid, String ballThree,
                    String BallsIntook, String ShotsMissed, String spunWheelColor,
                    String spunWheelTimes, String robotBroken, String soloClimb, String buddyClimb

                    -- Legacy stack of scores for the 2020 season
     */
    public TeleData(@NotNull String Match, String ballLow, String ballMid, String ballThree,
                    String BallsIntook, String ShotsMissed, String spunWheelColor,
                    String spunWheelTimes, String robotBroken, String soloClimb, String buddyClimb) {
        this.ballLow = ballLow;
        this.ballMid = ballMid;
        this.ballThree = ballThree;
        this.spunWheelColor = spunWheelColor;
        this.spunWheelTimes = spunWheelTimes;
        this.robotBroken = robotBroken;
        this.soloClimb = soloClimb;
        this.buddyClimb = buddyClimb;
        this.BallsIntook = BallsIntook;
        this.ShotsMissed = ShotsMissed;
        this.Match = Match;

    }


    public String getBallMid() {
        return ballMid;
    }

    public void setBallMid(String ballMid) {
        this.ballMid = ballMid;
    }

    public String getBallThree() {
        return ballThree;
    }

    public void setBallThree(String ballThree) {
        this.ballThree = ballThree;
    }

    public String getSpunWheelColor() {
        return spunWheelColor;
    }

    public void setSpunWheelColor(String spunWheelColor) {
        this.spunWheelColor = spunWheelColor;
    }

    public String getSpunWheelTimes() {
        return spunWheelTimes;
    }

    public void setSpunWheelTimes(String spunWheelTimes) {
        this.spunWheelTimes = spunWheelTimes;
    }

    public String getRobotBroken() {
        return robotBroken;
    }

    public void setRobotBroken(String robotBroken) {
        this.robotBroken = robotBroken;
    }

    public String getSoloClimb() {
        return soloClimb;
    }

    public void setSoloClimb(String soloClimb) {
        this.soloClimb = soloClimb;
    }

    public String getBuddyClimb() {
        return buddyClimb;
    }

    public void setBuddyClimb(String buddyClimb) {
        this.buddyClimb = buddyClimb;
    }

    public String getBallLow() {
        return ballLow;
    }

    @ColumnInfo(name = "ballLow")
    private String ballLow;

    @ColumnInfo(name = "ballMid")
    private String ballMid;

    @ColumnInfo(name = "ballThree")
    private String ballThree;

    @ColumnInfo(name = "spunWheelColor")
    private String spunWheelColor;

    @ColumnInfo(name = "spunWheelTimes")
    private String spunWheelTimes;

    @ColumnInfo(name = "robotBroke")
    private String robotBroken;

    @ColumnInfo(name = "soloClimb")
    private String soloClimb;

    @ColumnInfo(name = "buddyClimb")
    private String buddyClimb;

    @ColumnInfo(name = "BallsInook")
    private String BallsIntook;

    @ColumnInfo(name = "ShotsMissed")
    private String ShotsMissed;

    @PrimaryKey
    @NotNull

    @ColumnInfo(name = "match")
    private String Match;


    public void setBallLow(String ballLow) {
        this.ballLow = ballLow;
    }

    public String getBallsIntook() {
        return BallsIntook;
    }

    public void setBallsIntook(String ballsIntook) {
        BallsIntook = ballsIntook;
    }

    public String getShotsMissed() {
        return ShotsMissed;
    }

    public void setShotsMissed(String shotsMissed) {
        ShotsMissed = shotsMissed;
    }

    public String getMatch() {
        return Match;
    }

    public void setMatch(String match) {
        Match = match;
    }

}
