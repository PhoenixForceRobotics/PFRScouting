package edu.phoenixforce.scouting.mobile.database.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TeleData {

    public TeleData(String ballLow){
        this.ballLow = ballLow;

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

    @NonNull
    public String getBallLow() {
        return ballLow;
    }

    @PrimaryKey
    @NonNull
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

}
