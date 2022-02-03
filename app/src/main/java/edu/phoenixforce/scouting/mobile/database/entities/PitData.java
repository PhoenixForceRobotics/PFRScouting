package edu.phoenixforce.scouting.mobile.database.entities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;


@Entity
public class PitData {

    public PitData(@NotNull String teamNum, String botInfo, byte[] img_1, String robotThoughts, int priKey){

        this.teamNum = teamNum;
        this.botInfo = botInfo;
        this.img_1 = img_1;
        this.robotThoughts = robotThoughts;
        this.priKey = priKey;

    }

    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "priKey")
    private int priKey;

    @ColumnInfo(name = "teamNum")
    private String teamNum;

    @ColumnInfo(name = "botInfo")
    private String botInfo;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] img_1;

    @ColumnInfo(name = "robotThoughts")
    private String robotThoughts;

    public int getPriKey() {
        return priKey;
    }

    public void setPriKey(int priKey) {
        this.priKey = priKey;
    }

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

    public void setRobotThoughts(String robotThoughts) {
        this.robotThoughts = robotThoughts;
    }
}
