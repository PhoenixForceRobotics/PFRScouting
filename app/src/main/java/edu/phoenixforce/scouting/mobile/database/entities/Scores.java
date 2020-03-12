package edu.phoenixforce.scouting.mobile.database.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Scores {

    public Scores(String scout) {

        this.scout = scout;
        this.id = id;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;



    @ColumnInfo(name = "scouter")
    private String scout;

    public int id(){

        return id;
    }



    public void setId(int id) {
        this.id = id;
    }




    public String getScout() {
        return scout;
    }

    public void setScout(String scout) {
        this.scout = scout;
    }
}



