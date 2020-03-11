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

    public AutoData(String moved, String lowBall, String midBall, String highBall, String ballsIntook, String missed ) {

        this.moved = moved;
        this.lowBall = lowBall;
        this.midBall = midBall;
        this.highBall = highBall;
        this.ballsIntook = ballsIntook;
        this.missed = missed;

    }



    @PrimaryKey
    @NonNull

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

    public void setHighBall(String highBall) {
        this.highBall = highBall;
    }

    public String getBallsIntook() {
        return ballsIntook;
    }

    public void setBallsIntook(String ballsIntook) {
        this.ballsIntook = ballsIntook;
    }
}
