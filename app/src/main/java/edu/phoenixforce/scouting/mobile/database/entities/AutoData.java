package edu.phoenixforce.scouting.mobile.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity
public class AutoData extends Data {


    public AutoData(String moved, String lowBall, String midBall, String highBall, String touchedWheel) {

        this.moved = moved;
        this.lowBall = lowBall;
        this.midBall = midBall;
        this.highBall = highBall;
        this.touchedWheel = touchedWheel;

    }




    @ColumnInfo(name = "moved")
    private String moved;

    @ColumnInfo(name = "lowBall")
    private String lowBall;

    @ColumnInfo(name = "midBall")
    private String midBall;

    @ColumnInfo (name = "highBall")
    private String highBall;

    @ColumnInfo(name = "touchedWheel")
    private String touchedWheel;


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

    public String getTouchedWheel() {
        return touchedWheel;
    }

    public void setTouchedWheel(String touchedWheel) {
        this.touchedWheel = touchedWheel;
    }
}
