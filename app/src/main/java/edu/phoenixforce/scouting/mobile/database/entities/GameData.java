package edu.phoenixforce.scouting.mobile.database.entities;

import android.service.autofill.FieldClassification;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

//2022 Game Table

@Entity
public class GameData {

    //Create the variable for the columns in the table
    public GameData(@NotNull String Scout, String DevNum, String MatchNum, String TeamNum,
                    String AutoTopCones, String AutoMidCones, String AutoBottomCones, String AutoTopCubes,
                    String AutoMidCubes, String AutoBottomCubes, String TeleTopCones, String TeleMidCones,
                    String TeleBottomCones, String TeleTopCubes, String TeleMidCubes, String TeleBottomCubes,
                    String Defence, String AutoMoved, String AutoLeftCommunity, String AutoOnStation,
                    String AutoLevelOnStation, String TeleOnStation, String TeleLevelOnStation, String TeleMoved,
                    String TeleBroke, String TeleNoShow) {
        //Create our getters and setters - will we ever use them tho???
        //TODO THIS ^


        this.MatchNum = MatchNum;
        this.TeamNum = TeamNum;
        this.DevNum = DevNum;
        this.Scout = Scout;
        this.AutoTopCones = AutoTopCones;
        this.AutoMidCones = AutoMidCones;
        this.AutoBottomCones = AutoBottomCones;
        this.AutoTopCubes = AutoTopCubes;
        this.AutoMidCubes = AutoMidCubes;
        this.AutoBottomCubes = AutoBottomCubes;
        this.TeleTopCones = TeleTopCones;
        this.TeleMidCones = TeleMidCones;
        this.TeleBottomCones = TeleBottomCones;
        this.TeleTopCubes = TeleTopCubes;
        this.TeleMidCubes = TeleMidCubes;
        this.TeleBottomCubes = TeleBottomCubes;
        this.Defence = Defence;
        this.AutoMoved = AutoMoved;
        this.AutoLeftCommunity = AutoLeftCommunity;
        this.AutoOnStation = AutoOnStation;
        this.AutoLevelOnStation = AutoLevelOnStation;
        this.TeleOnStation = TeleOnStation;
        this.TeleLevelOnStation = TeleLevelOnStation;
        this.TeleMoved = TeleMoved;
        this.TeleBroke = TeleBroke;
        this.TeleNoShow = TeleNoShow;
    }

    //This is all horribly disorganized

    @NotNull
    public String getMatchNum() {
        return MatchNum;
    }

    public void setMatchNum(@NotNull String matchNum) {
        MatchNum = matchNum;
    }

    public String getScout() {
        return Scout;
    }

    public void setScout(String scout) {
        Scout = scout;
    }

    public String getTeamNum() {
        return TeamNum;
    }

    public void setTeamNum(String teamNum) {
        TeamNum = teamNum;
    }

    public String getDevNum() {
        return DevNum;
    }

    public void setDevNum(String devNum) {
        DevNum = devNum;
    }

    public String getAutoMoved() {
        return AutoMoved;
    }

    public void setAutoMoved(String autoMoved) {
        AutoMoved = autoMoved;
    }

    public String getTeleMoved() { return TeleMoved; }

    public void setTeleMoved(String teleMoved) { TeleMoved = teleMoved; }

    public String getAutoTopCones() {
        return AutoTopCones;
    }

    public void setAutoTopCones(String autoTopCones) {
        AutoTopCones = autoTopCones;
    }

    public String getAutoMidCones() {
        return AutoMidCones;
    }

    public void setAutoMidCones(String autoMidCones) {
        AutoMidCones = autoMidCones;
    }

    public String getAutoBottomCones() {
        return AutoBottomCones;
    }

    public void setAutoBottomCones(String autoBottomCones) { AutoBottomCones = autoBottomCones; }

    public String getAutoTopCubes() {
        return AutoTopCubes;
    }

    public void setAutoTopCubes(String autoTopCubes) {
        AutoTopCubes = autoTopCubes;
    }

    public String getAutoMidCubes() {
        return AutoMidCubes;
    }

    public void setAutoMidCubes(String autoMidCubes) {
        AutoMidCubes = autoMidCubes;
    }

    public String getAutoBottomCubes() {
        return AutoBottomCubes;
    }

    public void setAutoBottomCubes(String autoBottomCubes) {
        AutoBottomCubes = autoBottomCubes;
    }

    public String getTeleTopCones() {
        return TeleTopCones;
    }

    public void setTeleTopCones(String teleTopCones) {
        TeleTopCones = teleTopCones;
    }

    public String getTeleMidCones() {
        return TeleMidCones;
    }

    public void setTeleMidCones(String teleMidCones) {
        TeleMidCones = teleMidCones;
    }

    public String getTeleBottomCones() {
        return TeleBottomCones;
    }

    public void setTeleBottomCones(String teleBottomCones) { TeleBottomCones = teleBottomCones; }

    public String getTeleTopCubes() {
        return TeleTopCubes;
    }

    public void setTeleTopCubes(String teleTopCubes) {
        TeleTopCubes = teleTopCubes;
    }

    public String getTeleMidCubes() { return TeleMidCubes; }

    public void setTeleMidCubes(String teleMidCubes) {
        TeleMidCubes = teleMidCubes;
    }

    public String getTeleBottomCubes() {
        return TeleBottomCubes;
    }

    public void setTeleBottomCubes(String teleBottomCubes) {
        TeleBottomCubes = teleBottomCubes;
    }

    public String getDefence() {
        return Defence;
    }

    public void setDefence(String defence) {
        Defence = defence;
    }

    public String getAutoLeftCommunity() {
        return AutoLeftCommunity;
    }

    public void setAutoLeftCommunity(String autoLeftCommunity) { AutoLeftCommunity = autoLeftCommunity; }

    public String getAutoOnStation() {
        return AutoOnStation;
    }

    public void setAutoOnStation(String autoOnStation) {
        AutoOnStation = autoOnStation;
    }

    public String getAutoLevelOnStation() {
        return AutoLevelOnStation;
    }

    public void setAutoLevelOnStation(String autoLevelOnStation) { AutoLevelOnStation = autoLevelOnStation; }

    public String getTeleOnStation() {
        return TeleOnStation;
    }

    public void setTeleOnStation(String teleOnStation) {
        TeleOnStation = teleOnStation;
    }

    public String getTeleLevelOnStation() {
        return TeleLevelOnStation;
    }

    public void setTeleLevelOnStation(String teleLevelOnStation) { TeleLevelOnStation = teleLevelOnStation; }

    public String getTeleBroke() {
        return TeleBroke;
    }

    public void setTeleBroke(String teleBroke) {
        TeleBroke = teleBroke;
    }


    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "MatchNum")
    private String MatchNum;

    @ColumnInfo(name = "Scout")
    private String Scout;

    @ColumnInfo(name = "TeamNum")
    private String TeamNum;

    @ColumnInfo(name = "AutoMoved")
    private String AutoMoved;

    @ColumnInfo(name = "TeleMoved")
    private String TeleMoved;

    @ColumnInfo(name = "AutoTopCones")
    private String AutoTopCones;

    @ColumnInfo(name = "AutoMidCones")
    private String AutoMidCones;

    @ColumnInfo(name = "AutoBottomCones")
    private String AutoBottomCones;

    @ColumnInfo(name = "AutoTopCubes")
    private String AutoTopCubes;

    @ColumnInfo(name = "AutoMidCubes")
    private String AutoMidCubes;

    @ColumnInfo(name = "AutoBottomCubes")
    private String AutoBottomCubes;

    @ColumnInfo(name = "TeleTopCones")
    private String TeleTopCones;

    @ColumnInfo(name = "TeleMidCones")
    private String TeleMidCones;

    @ColumnInfo(name = "TeleBottomCones")
    private String TeleBottomCones;

    @ColumnInfo(name = "TeleTopCubes")
    private String TeleTopCubes;

    @ColumnInfo(name = "TeleMidCubes")
    private String TeleMidCubes;

    @ColumnInfo(name = "TeleBottomCubes")
    private String TeleBottomCubes;

    @ColumnInfo(name = "Defence")
    private String Defence;

    @ColumnInfo(name = "AutoLeftCommunity")
    private String AutoLeftCommunity;

    @ColumnInfo(name = "AutoLevelOnStation")
    private String AutoLevelOnStation;

    @ColumnInfo(name = "TeleOnStation")
    private String TeleOnStation;

    @ColumnInfo(name = "TeleLevelOnStation")
    private String TeleLevelOnStation;

    @ColumnInfo(name = "AutoOnStation")
    private String AutoOnStation;

    @ColumnInfo(name = "TeleBroke")
    private String TeleBroke;

    @ColumnInfo(name = "DevNum")
    private String DevNum;

    @ColumnInfo(name = "TeleNoShow")
    private final String TeleNoShow;
}
