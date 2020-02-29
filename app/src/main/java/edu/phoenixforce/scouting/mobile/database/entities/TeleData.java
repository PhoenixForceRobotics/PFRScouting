package edu.phoenixforce.scouting.mobile.database.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class TeleData {

    public TeleData(String ballLow, String ballMid, String ballThree, String timeStamp){
        this.ballLow = ballLow;
        this.ballMid = ballMid;
        this.ballThree = ballThree;
        //Cats are cute! ;)
        this.timeStamp = timeStamp;



    }
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "ballLow")
    private String ballLow;

    @ColumnInfo(name = "ballMid")
    private String ballMid;

    @ColumnInfo(name = "ballThree")
    private String ballThree;

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

    public String getMissedShot() {
        return missedShot;
    }

    public void setMissedShot(String missedShot) {
        this.missedShot = missedShot;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @ColumnInfo(name = "missedShot")
    private String missedShot;

    @ColumnInfo(name = "timeStamp")
    private String timeStamp;



    @NonNull
    public String getBallLow() {
        return ballLow;
    }

    public void setBallLow(@NonNull String ballLow) {
        this.ballLow = ballLow;
    }
}
