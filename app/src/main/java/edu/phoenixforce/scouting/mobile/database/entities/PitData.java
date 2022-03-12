package edu.phoenixforce.scouting.mobile.database.entities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;


@Entity
public class PitData {



    public PitData(@NotNull String teamNum, String robotThoughts, byte[] img_1, String botInfo, String projectedCycleTime, String projectedClimbLevel){

        this.teamNum = teamNum;
        this.botInfo = botInfo;
        this.img_1 = img_1;
        this.robotThoughts = robotThoughts;
        this.projectedCycleTime = projectedCycleTime;
        this.projectedClimbLevel = projectedClimbLevel;


    }

    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "teamNum")
    private String teamNum;

    @ColumnInfo(name = "botInfo")
    private String botInfo;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] img_1;

    @ColumnInfo(name = "robotThoughts")
    private String robotThoughts;

    @ColumnInfo(name = "projectedCycleTime")
    private String projectedCycleTime;

    @ColumnInfo(name = "projectedClimbLevel")
    private String projectedClimbLevel;

    public String getTeamNum() {
        return teamNum;
    }

    public void setTeamNum(String teamNum) {
        this.teamNum = teamNum;
    }

    public String getBotInfo() {
        return botInfo;
    }

    public void setBotInfo(String botInfo) {
        this.botInfo = botInfo;
    }

    public byte[] getImg_1() {
        return img_1;
    }

    public void setImg_1(byte[] img_1) {
        this.img_1 = img_1;
    }

    public String getRobotThoughts() {
        return robotThoughts;
    }
    public String getProjectedCycleTime() {
        return projectedCycleTime;
    }

    public String getProjectedClimbLevel() {
        return projectedClimbLevel;
    }
    public void setProjectedCycleTime(String projectedCycleTime) {
        this.projectedCycleTime = projectedCycleTime;
    }

    public void setProjectedClimbLevel(String projectedClimbLevel) {
        this.projectedClimbLevel = projectedClimbLevel;
    }
    public void setRobotThoughts(String robotThoughts) {
        this.robotThoughts = robotThoughts;
    }


}
