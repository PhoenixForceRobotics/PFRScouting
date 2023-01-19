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
                    String TeleBroke, String TeleNoShow, String TBoxOne, String TBoxTwo, String TBoxThree, String TBoxFour,
                    String TBoxFive, String TBoxSix, String TBoxSeven, String TBoxEight, String TBoxNine, String MBoxOne, String MBoxTwo,
                    String MBoxThree, String MBoxFour, String MBoxFive, String MBoxSix, String MBoxSeven, String MBoxEight, String MBoxNine,
                    String BBoxOne, String BBoxTwo, String BBoxThree, String BBoxFour, String BBoxFive, String BBoxSix, String BBoxSeven,
                    String BBoxEight, String BBoxNine) {
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
        this.TBoxOne = TBoxOne;
        this.TBoxTwo = TBoxTwo;
        this.TBoxThree = TBoxThree;
        this.TBoxFour = TBoxFour;
        this.TBoxFive = TBoxFive;
        this.TBoxSix = TBoxSix;
        this.TBoxSeven = TBoxSeven;
        this.TBoxEight = TBoxEight;
        this.TBoxNine = TBoxNine;
        this.MBoxOne = MBoxOne;
        this.MBoxTwo = MBoxTwo;
        this.MBoxThree = MBoxThree;
        this.MBoxFour = MBoxFour;
        this.MBoxFive = MBoxFive;
        this.MBoxSix = MBoxSix;
        this.MBoxSeven = MBoxSeven;
        this.MBoxEight = MBoxEight;
        this.MBoxNine = MBoxNine;
        this.BBoxOne = BBoxOne;
        this.BBoxTwo = BBoxTwo;
        this.BBoxThree = BBoxThree;
        this.BBoxFour = BBoxFour;
        this.BBoxFive = BBoxFive ;
        this.BBoxSix = BBoxSix;
        this.BBoxSeven = BBoxSeven;
        this.BBoxEight = BBoxEight;
        this.BBoxNine = BBoxNine;



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

    public String getTBoxOne() {
        return TBoxOne;
    }

    public void setTBoxOne(String tBoxOne) {
        TBoxOne = tBoxOne;
    }

    public String getTBoxTwo() {
        return TBoxTwo;
    }

    public void setTBoxTwo(String tBoxTwo) {
        TBoxTwo = tBoxTwo;
    }

    public String getTBoxThree() { return TBoxTwo; }

    public void setTBoxThree(String tBoxThree) { TBoxThree = tBoxThree; }

    public String getTBoxFour() {
        return TBoxFour;
    }

    public void setTBoxFour(String tBoxFour) { TBoxFour = tBoxFour; }

    public String getTBoxFive() { return TBoxFive; }

    public void setTBoxFive(String tBoxFive) {
        TBoxFive = tBoxFive;
    }

    public String getTBoxSix() {
        return TBoxSix;
    }

    public void setTBoxSix(String tBoxSix) {
        TBoxSix = tBoxSix;
    }

    public String getTBoxSeven() {
        return TBoxSeven;
    }

    public void setTBoxSeven(String tBoxSeven) { TBoxSeven = tBoxSeven; }

    public String getTBoxEight() {
        return TBoxEight;
    }

    public void setTBoxEight(String tBoxEight) { TBoxEight = tBoxEight; }

    public String getTBoxNine() {
        return TBoxNine;
    }

    public void setTBoxNine(String tBoxNine) {
        TBoxNine = tBoxNine;
    }

    public String getMBoxOne() {
        return MBoxOne;
    }

    public void setMBoxOne(String mBoxOne) {
        MBoxOne = mBoxOne;
    }

    public String getMBoxTwo() {
        return MBoxTwo;
    }

    public void setMBoxTwo(String mBoxTwo) {
        MBoxTwo = mBoxTwo;
    }

    public String getMBoxThree() {
        return MBoxThree;
    }

    public void setMBoxThree(String mBoxThree) {
        MBoxThree = mBoxThree;
    }

    public String getMBoxFour() {
        return MBoxFour;
    }

    public void setMBoxFour(String mBoxFour) {
        MBoxFour = mBoxFour;
    }

    public String getMBoxFive() {
        return MBoxFive;
    }

    public void setMBoxFive(String mBoxFive) {
        MBoxFive = mBoxFive;
    }

    public String getMBoxSix() {
        return MBoxSix;
    }

    public void setMBoxSix(String mBoxSix) {
        MBoxSix = mBoxSix;
    }

    public String getMBoxSeven() {
        return MBoxSeven;
    }

    public void setMBoxSeven(String mBoxSeven) {
        MBoxSeven = mBoxSeven;
    }

    public String getMBoxEight() {
        return MBoxEight;
    }

    public void setMBoxEight(String mBoxEight) {
        MBoxEight = mBoxEight;
    }

    public String getMBoxNine() {
        return MBoxNine;
    }

    public void setMBoxNine(String mBoxNine) {
        MBoxNine = mBoxNine;
    }

    public String getBBoxOne() {
        return BBoxOne;
    }

    public void setBBoxOne(String bBoxOne) { BBoxOne = bBoxOne; }

    public String getBBoxTwo() {
        return BBoxTwo;
    }

    public void setBBoxTwo(String bBoxTwo) { BBoxTwo = bBoxTwo; }

    public String getBBoxThree() {
        return BBoxThree;
    }

    public void setBBoxThree(String bBoxThree) { BBoxThree = bBoxThree; }

    public String getBBoxFour() {
        return BBoxFour;
    }

    public void setBBoxFour(String bBoxFour) { BBoxFour = bBoxFour; }

    public String getBBoxFive() { return BBoxFive; }

    public void setBBoxFive(String bBoxFive) { BBoxFive = bBoxFive; }

    public String getBBoxSix() {
        return BBoxSix;
    }

    public void setBBoxSix(String bBoxSix) { BBoxSix = bBoxSix; }

    public String getBBoxSeven() { return BBoxSeven; }

    public void setBBoxSeven(String bBoxSeven) { BBoxSeven = bBoxSeven; }

    public String getBBoxEight() {
        return BBoxEight;
    }

    public void setBBoxEight(String bBoxEight) { BBoxEight = bBoxEight; }

    public String getBBoxNine() {
        return BBoxNine;
    }

    public void setBBoxNine(String bBoxNine) { BBoxNine = bBoxNine; }

    public String getTeleNoShow() {
        return TeleNoShow;
    }

    public void setTeleNoShow(String teleNoShow) {
        TeleNoShow = teleNoShow;
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
    private String TeleNoShow;

    @ColumnInfo(name = "TBoxOne")
    private String TBoxOne;

    @ColumnInfo(name = "TBoxTwo")
    private String TBoxTwo;

    @ColumnInfo(name = "TBoxThree")
    private String TBoxThree;

    @ColumnInfo(name = "TBoxFour")
    private String TBoxFour;

    @ColumnInfo(name = "TBoxFive")
    private String TBoxFive;

    @ColumnInfo(name = "TBoxSix")
    private String TBoxSix;

    @ColumnInfo(name = "TBoxSeven")
    private String TBoxSeven;

    @ColumnInfo(name = "TBoxEight")
    private String TBoxEight;

    @ColumnInfo(name = "TBoxNine")
    private String TBoxNine;

    @ColumnInfo(name = "MBoxOne")
    private String MBoxOne;

    @ColumnInfo(name = "MBoxTwo")
    private String MBoxTwo;

    @ColumnInfo(name = "MBoxThree")
    private String MBoxThree;

    @ColumnInfo(name = "MBoxFour")
    private String MBoxFour;

    @ColumnInfo(name = "MBoxFive")
    private String MBoxFive ;

    @ColumnInfo(name = "MBoxSix")
    private String MBoxSix;

    @ColumnInfo(name = "MBoxSeven")
    private String MBoxSeven;

    @ColumnInfo(name = "MBoxEight")
    private String MBoxEight;

    @ColumnInfo(name = "MBoxNine")
    private String MBoxNine;

    @ColumnInfo(name = "BBoxOne")
    private String BBoxOne;

    @ColumnInfo(name = "BBoxTwo")
    private String BBoxTwo;

    @ColumnInfo(name = "BBoxThree")
    private String BBoxThree;

    @ColumnInfo(name = "BBoxFour")
    private String BBoxFour;

    @ColumnInfo(name = "BBoxFive")
    private String BBoxFive;

    @ColumnInfo(name = "BBoxSix")
    private String BBoxSix;

    @ColumnInfo(name = "BBoxSeven")
    private String BBoxSeven;

    @ColumnInfo(name = "BBoxEight")
    private String BBoxEight;

    @ColumnInfo(name = "BBoxNine")
    private String BBoxNine;
}
