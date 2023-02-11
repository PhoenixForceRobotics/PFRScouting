package edu.phoenixforce.scouting.mobile.common;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.util.Log;
import android.content.SharedPreferences;


import edu.phoenixforce.scouting.mobile.database.ScoreDataBase;
import edu.phoenixforce.scouting.mobile.database.entities.GameData;

public class Constants {
    private android.app.Application Application;
    String matchNumber;
    String teamNumber;
    public static final String CONFIG_FILE_NAME = "edu.pheonicforce.scouting.mobile";
    public static final String KEY_DEVICE_ID = CONFIG_FILE_NAME + "DeviceId";

    //Not sure what this cluster of getters and setters is being used for
    public String getMatchNumber() {
        return matchNumber;
    }
    public String getTeamNumber() {
        return teamNumber;
    }
    public void setMatchNumber(String MatchNumber) { this.matchNumber = MatchNumber;}

    public int getDeviceId() {return deviceId;}

    int deviceId = 0;

    public void setTeamNumber(String TeamNumber) { this.teamNumber = TeamNumber;}

    public static int getExternalFileStoragePermission() {
        return EXTERNAL_FILE_STORAGE_PERMISSION;
    }
    public void getPrefs(Context context) {
        SharedPreferences myPrefs = context.getSharedPreferences(CONFIG_FILE_NAME, MODE_PRIVATE);
        deviceId = myPrefs.getInt(KEY_DEVICE_ID, deviceId);
    }

    //important
    public static final int EXTERNAL_FILE_STORAGE_PERMISSION = 1;
    //important - DB will not work or transfer without this variable
    //Used in Activity Main
}





