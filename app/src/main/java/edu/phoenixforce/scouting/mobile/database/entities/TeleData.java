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

    @ColumnInfo(name = "")



    @NonNull
    public String getBallLow() {
        return ballLow;
    }

    public void setBallLow(@NonNull String ballLow) {
        this.ballLow = ballLow;
    }
}
