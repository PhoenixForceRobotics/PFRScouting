package edu.phoenixforce.scouting.mobile.database.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Calendar;
import java.util.Date;

//@Entity(tableName = "data_table")
public class Data {

    public Data( ){

        //this.timeStamp = new Date();
        this.currentScout = currentScout;
        this.devNum = devNum;

        //Here we can get things like the device id and time number

    }

    @PrimaryKey
    @NonNull
   /* @ColumnInfo(name = "time_Stamp")
    private Date timeStamp;*/

  /*  @ColumnInfo(name = "date_Stamp")
    private Date dateStamp;

   */ //Not currently needed so far as I know

    @ColumnInfo(name = "scout")
    private String currentScout;

    @ColumnInfo(name = "devId")
    private int devNum;

    public String getTeamKey() {
        return teamKey;
    }

    public void setTeamKey(String teamKey) {
        this.teamKey = teamKey;
    }

    public String getMatchKey() {
        return matchKey;
    }

    public void setMatchKey(String matchKey) {
        this.matchKey = matchKey;
    }

    @ColumnInfo(name = "team_Key")
    private String teamKey;

    @ColumnInfo(name = "match_Key")
    private String matchKey;

   /* @NonNull
    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(@NonNull Date timeStamp) {
        this.timeStamp = timeStamp;
    } */

    public String getCurrentScout() {
        return currentScout;
    }

    public void setCurrentScout(String currentScout) {
        this.currentScout = currentScout;
    }

    public int getDevNum() {
        return devNum;
    }

    public void setDevNum(int devNum) {
        this.devNum = devNum;
    }











}
