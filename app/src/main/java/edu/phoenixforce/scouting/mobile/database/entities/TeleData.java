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



    @NonNull
    public String getBallLow() {
        return ballLow;
    }

    public void setBallLow(@NonNull String ballLow) {
        this.ballLow = ballLow;
    }
}
