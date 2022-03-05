package edu.phoenixforce.scouting.mobile.common;

import static android.content.Context.MODE_PRIVATE;
import static edu.phoenixforce.scouting.mobile.layouts.login.SHARED_PREFS;

import android.content.Context;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.content.SharedPreferences;
import edu.phoenixforce.scouting.*;
import edu.phoenixforce.scouting.mobile.layouts.Configuration;
import edu.phoenixforce.scouting.mobile.layouts.login;


import edu.phoenixforce.scouting.mobile.database.ScoreDataBase;
import edu.phoenixforce.scouting.mobile.database.entities.GameData;
import edu.phoenixforce.scouting.mobile.functions.Timer;
import edu.phoenixforce.scouting.mobile.database.entities.GameData;

public class Constants {
    String robotInfo;
    String userThoughts;
    String projectedCycleTime;
    String projectedClimbLevel;
    String matchNumber;
    String teamNumber;
    String user;
    int devId;


    public void setRobotInfo(String text1) {
        this.robotInfo = text1;
    }

    public void setUserThoughts(String text2) {
        this.userThoughts = text2;
    }

    public void setProjectedCycleTime(String text3) {
        this.projectedCycleTime = text3;
    }

    public void setUser(String user) { this.user  = user;}

    public void setMatchNumber(String MatchNumber) { this.matchNumber = MatchNumber;}

    public void setTeamNumber(String TeamNumber) { this.teamNumber = TeamNumber;}

    public void setProjectedClimbLevel(String text4) {
        this.projectedClimbLevel = text4;
    }

    public String getRobotInfo() {
        return robotInfo;
    }

    public String getUserThoughts() {
        return userThoughts;
    }



    public String getProjectedCycleTime() {
        return projectedCycleTime;
    }

    public String getProjectedClimbLevel() {
        return projectedClimbLevel;
    }

    public static final int EXTERNAL_FILE_STORAGE_PERMISSION = 1;


    private static final String CONFIG_FILE_NAME = "edu.phoenixforce.scouting.mobile";
    private static final String KEY_DEVICE_ID = CONFIG_FILE_NAME + ".DeviceId";
    private static final String KEY_TBA_TEAM_ID = CONFIG_FILE_NAME + ".TbaTeamId";
    private static final String KEY_TBA_LAST_MODIFIED = CONFIG_FILE_NAME + ".TbaLastModified";

    int one = 0;
    int two = 0;
    int three = 0;
    int four = 0;
    int five = 0;
    int six = 0;
    int seven = 0;
    int eight = 0;
    int nine = 0;
    int ten = 0;
    int eleven = 0;
    int twelve = 0;
    int thirteen = 0;
    int fourteen = 0;
    private android.app.Application Application;

    int autoOne = 0;
    int autoTwo = 0;
    int autoThree = 0;
    int autoFour = 0;
    int autoFive = 0;
    int autoSix = 0;

    public int getAutoOne() {
        return autoOne;
    }

    public void setAutoOne(int autoOne) {
        this.autoOne = autoOne;
    }

    public int getAutoTwo() {
        return autoTwo;
    }

    public void setAutoTwo(int autoTwo) {
        this.autoTwo = autoTwo;
    }

    public int getAutoThree() {
        return autoThree;
    }

    public void setAutoThree(int autoThree) {
        this.autoThree = autoThree;
    }

    public int getAutoFour() {
        return autoFour;
    }

    public void setAutoFour(int autoFour) {
        this.autoFour = autoFour;
    }

    public int getAutoFive() {
        return autoFive;
    }

    public void setAutoFive(int autoFive) {
        this.autoFive = autoFive;
    }

    public int getAutoSix() {
        return autoSix;
    }

    public void setAutoSix(int autoSix) {
        this.autoSix = autoSix;
    }

    public int getAutoSeven() {
        return autoSeven;
    }

    public void setAutoSeven(int autoSeven) {
        this.autoSeven = autoSeven;
    }

    public int getAutoEight() {
        return autoEight;
    }

    public void setAutoEight(int autoEight) {
        this.autoEight = autoEight;
    }

    public int getAutoNine() {
        return autoNine;
    }

    public void setAutoNine(int autoNine) {
        this.autoNine = autoNine;
    }

    public int getAutoTen() {
        return autoTen;
    }

    public void setAutoTen(int autoTen) {
        this.autoTen = autoTen;
    }

    int autoSeven = 0;
    int autoEight = 0;
    int autoNine = 0;
    int autoTen = 0;

    public void setOne(int one) {
        this.one = one;
    }

    public void setSeventeen(int seventeen) {
        this.seventeen = seventeen;
    }


    public void setTen(int ten) {
        this.ten = ten;
    }

    public void setEleven(int eleven) {
        this.eleven = eleven;
    }

    public void setTwelve(int twelve) {
        this.twelve = twelve;
    }

    public void setThirteen(int thirteen) {
        this.thirteen = thirteen;
    }

    public void setFourteen(int fourteen) {
        this.fourteen = fourteen;
    }

    public void setFifteen(int fifteen) {
        this.fifteen = fifteen;
    }

    public void setSixteen(int sixteen) {
        this.sixteen = sixteen;
    }

    public void setTwo(int two) {
        this.two = two;
    }

    public void setThree(int three) {
        this.three = three;
    }

    public void setFour(int four) {
        this.four = four;
    }

    public void setFive(int five) {
        this.five = five;
    }

    public void setSix(int six) {
        this.six = six;
    }

    public void setSeven(int seven) {
        this.seven = seven;
    }

    public void setEight(int eight) {
        this.eight = eight;
    }

    public void setNine(int nine) {
        this.nine = nine;
    }

    int fifteen = 0;
    int sixteen = 0;
    int seventeen = 0;


    int deviceId;


    public void getPrefs(Context context) {

        SharedPreferences myPrefs = context.getSharedPreferences(CONFIG_FILE_NAME, MODE_PRIVATE);
        deviceId = myPrefs.getInt(KEY_DEVICE_ID, 0);


//GameData gameData = new GameData(String.valueOf(eleven),String.valueOf(twelve),String.valueOf(one),String.valueOf(two), String.valueOf(three),String.valueOf(four),String.valueOf(five),String.valueOf(six));

    }
}





