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
                    String TeleBroke, String TeleNoShow, String TBox1, String TBox2, String TBox3, String TBox4,
                    String TBox5, String TBox6, String TBox7, String TBox8, String TBox9, String MBox1, String MBox2,
                    String MBox3, String MBox4, String MBox5, String MBox6, String MBox7, String MBox8, String MBox9,
                    String BBox1, String BBox2, String BBox3, String BBox4, String BBox5, String BBox6, String BBox7,
                    String BBox8, String BBox9) {
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
        this.TBox1 = TBox1;
        this.TBox2 = TBox2;
        this.TBox3 = TBox3;
        this.TBox4 = TBox4;
        this.TBox5 = TBox5;
        this.TBox6 = TBox6;
        this.TBox7 = TBox7;
        this.TBox8 = TBox8;
        this.TBox9 = TBox9;
        this.MBox1 = MBox1;
        this.MBox2 = MBox2;
        this.MBox3 = MBox3;
        this.MBox4 = MBox4;
        this.MBox5 = MBox5;
        this.MBox6 = MBox6;
        this.MBox7 = MBox7;
        this.MBox8 = MBox8;
        this.MBox9 = MBox9;
        this.BBox1 = BBox1;
        this.BBox2 = BBox2;
        this.BBox3 = BBox3;
        this.BBox4 = BBox4;
        this.BBox5 = BBox5;
        this.BBox6 = BBox6;
        this.BBox7 = BBox7;
        this.BBox8 = BBox8;
        this.BBox9 = BBox9;



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

    public String getTBox1() {
        return TBox1;
    }

    public void setTBox1(String tBox1) {
        TBox1 = tBox1;
    }

    public String getTBox2() {
        return TBox2;
    }

    public void setTBox2(String tBox2) {
        TBox2 = tBox2;
    }

    public String getTBox3() { return TBox3; }

    public void setTBox3(String tBox3) {
        TBox3 = tBox3;
    }

    public String getTBox4() {
        return TBox4;
    }

    public void setTBox4(String tBox4) {
        TBox4 = tBox4;
    }

    public String getTBox5() {
        return TBox5;
    }

    public void setTBox5(String tBox5) {
        TBox5 = tBox5;
    }

    public String getTBox6() {
        return TBox6;
    }

    public void setTBox6(String tBox6) {
        TBox6 = tBox6;
    }

    public String getTBox7() {
        return TBox7;
    }

    public void setTBox7(String tBox7) { TBox7 = tBox7; }

    public String getTBox8() {
        return TBox8;
    }

    public void setTBox8(String tBox8) {
        TBox8 = tBox8;
    }

    public String getTBox9() {
        return TBox9;
    }

    public void setTBox9(String tBox9) {
        TBox9 = tBox9;
    }

    public String geMBox1() {
        return MBox1;
    }

    public void setMBox1(String mBox1) {
        MBox1 = mBox1;
    }

    public String geMBox2() {
        return MBox2;
    }

    public void setMBox2(String mBox2) {
        MBox2 = mBox2;
    }

    public String geMBox3() {
        return MBox3;
    }

    public void setMBox3(String mBox3) {
        MBox3 = mBox3;
    }

    public String geMBox4() {
        return MBox4;
    }

    public void setMBox4(String mBox4) {
        MBox4 = mBox4;
    }

    public String geMBox5() {
        return MBox5;
    }

    public void setMBox5(String mBox5) {
        MBox5 = mBox5;
    }

    public String geMBox6() {
        return MBox6;
    }

    public void setMBox6(String mBox6) {
        MBox6 = mBox6;
    }

    public String geMBox7() {
        return MBox7;
    }

    public void setMBox7(String mBox7) {
        MBox7 = mBox7;
    }

    public String geMBox8() {
        return MBox8;
    }

    public void setMBox8(String mBox8) {
        MBox8 = mBox8;
    }

    public String geMBox9() {
        return MBox9;
    }

    public void setMBox9(String mBox9) {
        MBox9 = mBox9;
    }

    public String geBBox1() {
        return BBox1;
    }

    public void setBBox1(String bBox1) { BBox1 = bBox1; }

    public String geBBox2() {
        return BBox2;
    }

    public void setBBox2(String bBox2) { BBox2 = bBox2; }

    public String geBBox3() {
        return BBox3;
    }

    public void setBBox3(String bBox3) { BBox3 = bBox3; }

    public String geBBox4() {
        return BBox4;
    }

    public void setBBox4(String bBox4) { BBox4 = bBox4; }

    public String geBBox5() { return BBox5; }

    public void setBBox5(String bBox5) { BBox5 = bBox5; }

    public String geBBox6() {
        return BBox6;
    }

    public void setBBox6(String bBox6) { BBox6 = bBox6; }

    public String geBBox7() {
        return BBox7;
    }

    public void setBBox7(String bBox7) { BBox7 = bBox7; }

    public String geBBox8() {
        return BBox8;
    }

    public void setBBox8(String bBox8) { BBox8 = bBox8; }

    public String geBBox9() {
        return BBox9;
    }

    public void setBBox9(String bBox9) { BBox9 = bBox9; }



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

    @ColumnInfo(name = "TBox1")
    private String TBox1;

    @ColumnInfo(name = "TBox2")
    private String TBox2;

    @ColumnInfo(name = "TBox3")
    private String TBox3;

    @ColumnInfo(name = "TBox4")
    private String TBox4;

    @ColumnInfo(name = "TBox5")
    private String TBox5;

    @ColumnInfo(name = "TBox6")
    private String TBox6;

    @ColumnInfo(name = "TBox7")
    private String TBox7;

    @ColumnInfo(name = "TBox8")
    private String TBox8;

    @ColumnInfo(name = "TBox9")
    private String TBox9;

    @ColumnInfo(name = "MBox1")
    private String MBox1;

    @ColumnInfo(name = "MBox2")
    private String MBox2;

    @ColumnInfo(name = "MBox3")
    private String MBox3;

    @ColumnInfo(name = "MBox4")
    private String MBox4;

    @ColumnInfo(name = "MBox5")
    private String MBox5;

    @ColumnInfo(name = "MBox6")
    private String MBox6;

    @ColumnInfo(name = "MBox7")
    private String MBox7;

    @ColumnInfo(name = "MBox8")
    private String MBox8;

    @ColumnInfo(name = "MBox9")
    private String MBox9;

    @ColumnInfo(name = "BBox1")
    private String BBox1;

    @ColumnInfo(name = "BBox2")
    private String BBox2;

    @ColumnInfo(name = "BBox3")
    private String BBox3;

    @ColumnInfo(name = "BBox4")
    private String BBox4;

    @ColumnInfo(name = "BBox5")
    private String BBox5;

    @ColumnInfo(name = "BBox6")
    private String BBox6;

    @ColumnInfo(name = "BBox7")
    private String BBox7;

    @ColumnInfo(name = "BBox8")
    private String BBox8;

    @ColumnInfo(name = "BBox9")
    private String BBox9;
}
