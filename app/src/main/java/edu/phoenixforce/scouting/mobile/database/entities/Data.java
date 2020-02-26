package edu.phoenixforce.scouting.mobile.database.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Calendar;
import java.util.Date;

@Entity(tableName = "data_table")
public class Data {

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

    public Data( ){

        //this.timeStamp = new Date();
        this.currentScout = currentScout;
        this.devNum = devNum;


    }









}
