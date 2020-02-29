package edu.phoenixforce.scouting.mobile.database.The_other_ways_of_scoring;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import edu.phoenixforce.scouting.mobile.database.entities.Data;

@Entity(tableName = "Climber Scores")
public class ClimberScore extends Data {

    public ClimberScore(int CanClimb, int CanBuddyClimb, int BrokeDown, int DefenceMostOfTheTime) {
        this.CanClimb = CanClimb;
        this.CanBuddyClimb = CanBuddyClimb;
        this.BrokeDown = BrokeDown;
        this.DefenceMostOfTheTime = DefenceMostOfTheTime;
    }

    public int isCanClimb() {
        return CanClimb;
    }

    public void setCanClimb(int canClimb) {
        CanClimb = canClimb;
    }

    public int isCanBuddyClimb() {
        return CanBuddyClimb;
    }

    public void setCanBuddyClimb(int canBuddyClimb) {
        CanBuddyClimb = canBuddyClimb;
    }

    public int isBrokeDown() {
        return BrokeDown;
    }

    public void setBrokeDown(int brokeDown) {
        BrokeDown = brokeDown;
    }

    public int isDefenceMostOfTheTime() {
        return DefenceMostOfTheTime;
    }

    public void setDefenceMostOfTheTime(int defenceMostOfTheTime) {
        DefenceMostOfTheTime = defenceMostOfTheTime;
    }

    public int getCanClimb() {
        return CanClimb;
    }

    public int getCanBuddyClimb() {
        return CanBuddyClimb;
    }

    public int getBrokeDown() {
        return BrokeDown;
    }

    public int getDefenceMostOfTheTime() {
        return DefenceMostOfTheTime;
    }


    @NotNull
    @ColumnInfo(name = "Can Climb")
    private int CanClimb;

    @ColumnInfo(name = "Can Buddy Climb")
    private int CanBuddyClimb;

    @ColumnInfo(name = "Broke Down")
    private int BrokeDown;

    @ColumnInfo(name = "Defence Most Of The Time")
    private int DefenceMostOfTheTime;




}
