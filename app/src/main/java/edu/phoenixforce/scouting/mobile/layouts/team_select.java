package edu.phoenixforce.scouting.mobile.layouts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fyrebirdscout11.R;

import static edu.phoenixforce.scouting.mobile.layouts.login.SHARED_PREFS;

public class team_select extends AppCompatActivity {


    Button finished;

    EditText match, team;

    public static  String matchNumber, teamNumber;

    public String show1, show2;

    public static final String matchNum = "matchNumber";
    public static final String teamNum = "teamNumber";




    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_select);

        //loadData();

        SharedPreferences myPrefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        show1 = myPrefs.getString(matchNum, "");
        show2 = myPrefs.getString(teamNum, "");




        finished = findViewById(R.id.goScout);
        match = findViewById(R.id.matchNum);
        team = findViewById(R.id.teams);
        matchNumber = match.getText().toString();
        teamNumber = team.getText().toString();

        match.setText(show1);
        team.setText(show2);

        finished.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                saveData();


            }});


    }

    public void saveData(){



            SharedPreferences myPrefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
            SharedPreferences.Editor editor = myPrefs.edit();

            editor.putString(matchNum, matchNumber);
            editor.putString(teamNum, teamNumber);

            editor.apply();

            Toast.makeText(this, "Saved Data", Toast.LENGTH_SHORT).show();


            goScore();
        }














    public void goScore(){

        Intent intent = new Intent(this, ActivityMain.class);
        startActivity(intent);

    }
}

