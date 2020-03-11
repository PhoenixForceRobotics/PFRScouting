package edu.phoenixforce.scouting.mobile.database.entities;

import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.fyrebirdscout11.R;

import edu.phoenixforce.scouting.mobile.layouts.login;
import edu.phoenixforce.scouting.mobile.layouts.ConfigActivity;
import edu.phoenixforce.scouting.mobile.layouts.team_select;

import java.util.Calendar;
import java.util.Date;

import static android.content.Context.MODE_PRIVATE;
import static edu.phoenixforce.scouting.mobile.layouts.login.SHARED_PREFS;
import static edu.phoenixforce.scouting.mobile.layouts.login.TEXT;

//@Entity(tableName = "data_table")
public class Data  {



    Data(){





        //this.timeStamp = new Date();
        this.currentScout = (login.text)  ;
        //this.devNum = (ConfigActivity.deviceId);
        this.match = (team_select.matchNumber);
        this.team =  (team_select.teamNumber);

        //Here we can get things like the device id and time number

    }

    @PrimaryKey
    @NonNull
   /* @ColumnInfo(name = "time_Stamp")
    private Date timeStamp;*/

  /*  @ColumnInfo(name = "date_Stamp")
    private Date dateStamp;

   */ //Not currently needed so far as I know

    @ColumnInfo(name = "scout")
    private String currentScout;

    @ColumnInfo(name = "devId")
    private int devNum;

    @ColumnInfo(name = "team")
    private String team;

    @ColumnInfo(name = "match")
    private String match;
    public String getTeamKey() {
        return team;
    }

    public void setTeamKey(String team) {
        this.team = team;
    }

    public String getMatchKey() {
        return match;
    }

    public void setMatchKey(String match) {
        this.match = match;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }


   /* @NonNull
    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(@NonNull Date timeStamp) {
        this.timeStamp = timeStamp;
    } */

    public String getCurrentScout() {
        return currentScout;
    }

    public void setCurrentScout(String currentScout) {
        this.currentScout = currentScout;
    }

    public int getDevNum() {
        return devNum;
    }

    public void setDevNum(int devNum) {
        this.devNum = devNum;
    }








public void scoutName(){



}


}
