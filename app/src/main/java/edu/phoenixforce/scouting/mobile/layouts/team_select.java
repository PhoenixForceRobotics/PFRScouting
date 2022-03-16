package edu.phoenixforce.scouting.mobile.layouts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fyrebirdscout11.R;

import static edu.phoenixforce.scouting.mobile.layouts.login.SHARED_PREFS;

import edu.phoenixforce.scouting.mobile.common.Constants;

public class team_select extends AppCompatActivity {


    Button finished;

    TextView match, team;

    public static  String matchNumber = "0";
    public static String teamNumber = "0";
    public static String show1;
    public String show2;

    public static final String matchNum = "matchNumber";
    public static final String teamNum = "teamNumber";
    Constants constants = new Constants();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_select);

        //loadData();

        SharedPreferences myPrefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        show1 = myPrefs.getString(matchNum, "0");
        show2 = myPrefs.getString(teamNum, "0");






        finished = findViewById(R.id.goScout);
        match = findViewById(R.id.matchNum);
        team = findViewById(R.id.teams);

        mediatorMethod();






    }

    public void mediatorMethod(){

        finished.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                saveData();


            }});

    }

    public void saveData(){

            matchNumber = match.getText().toString();
            teamNumber = team.getText().toString();
            //constants.setMatchNumber(matchNumber);
           // constants.setTeamNumber(teamNumber); TODO

            if(teamNumber.toString().length() == 0){

               Toast.makeText(this,"No input detected :(", Toast.LENGTH_SHORT).show();
                mediatorMethod();

            }

            else if(matchNumber.toString().length() == 0){

                Toast.makeText(this,"No input detected :(", Toast.LENGTH_SHORT).show();
                mediatorMethod();
            }

            else{
            SharedPreferences myPrefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
            SharedPreferences.Editor editor = myPrefs.edit();

            editor.putString(matchNum, matchNumber);
            editor.putString(teamNum, teamNumber);




            editor.apply();
            TeleScore teleScore = new TeleScore();
            teleScore.setImportedTeamNum(teamNumber);
            teleScore.setImportedMatchNum(matchNumber);

            Log.d("team_select", teamNumber + matchNumber);



            goScore();

        }
        }














    public void goScore(){



        constants.setMatchNumber(matchNumber);


        constants.setTeamNumber(teamNumber);

        Log.d("constants check", constants.getMatchNumber() + constants.getTeamNumber());
        Toast.makeText(this, "Saved Data" + constants.getMatchNumber() + constants.getTeamNumber(), Toast.LENGTH_SHORT).show();




        Intent intent = new Intent(this, AutoScore.class);
        startActivity(intent);
    }
}

