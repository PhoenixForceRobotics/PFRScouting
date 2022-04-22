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

    //Not sure what this cluster of getters and setters is being used for
    public String getMatchNumber() {
        return matchNumber;
    }
    public String getTeamNumber() {
        return teamNumber;
    }
    public void setMatchNumber(String MatchNumber) { this.matchNumber = MatchNumber;}

    public void setTeamNumber(String TeamNumber) { this.teamNumber = TeamNumber;}

    public static int getExternalFileStoragePermission() {
        return EXTERNAL_FILE_STORAGE_PERMISSION;
    }

    //important
    public static final int EXTERNAL_FILE_STORAGE_PERMISSION = 1;
    //important - DB will not work or transfer without this variable
    //Used in Activity Main
}





