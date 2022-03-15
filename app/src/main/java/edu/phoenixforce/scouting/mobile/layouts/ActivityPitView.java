package edu.phoenixforce.scouting.mobile.layouts;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.fyrebirdscout11.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import edu.phoenixforce.scouting.mobile.database.ScoreDataBase;
import edu.phoenixforce.scouting.mobile.database.entities.PitData;

public class ActivityPitView extends AppCompatActivity{

    EditText teamnum;
    Button search;
    TextView Cycle;
    TextView climb;
    TextView botInfo;
    TextView botThoughts;
    ImageView imageView;
    Button finished;

    String id;
    int idInt;

    private List<PitData> pit = new ArrayList<>();
    private List<String> teams = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("ActivityPitView","onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pit_view);

        teamnum = findViewById(R.id.teamNumber1);
        search = findViewById(R.id.SearchTeam);

        Cycle = findViewById(R.id.Cycle);
        climb = findViewById(R.id.climb);
        botInfo = findViewById(R.id.info);
        botThoughts = findViewById(R.id.Thoughts);

        finished = findViewById(R.id.finishedView);

        imageView = findViewById(R.id.picBox);

        finished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                goHome();

            }
        });

        search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("ActivityPitView","onClick");
                Log.d("ActivityPitView",
                id = teamnum.getText().toString());
                idInt = Integer.parseInt(id);
                Log.d("dataPull", "Ran searchData");


                if(id.length() > 0) {

                    searchData();

                }

                else{
                    Toast.makeText(ActivityPitView.this, "Enter a Team Number", Toast.LENGTH_LONG).show();
                }

            }


        });

    }

    public void searchData(){
        Log.d("ActivityPitView", "searchData");

        ScoreDataBase SDB = ScoreDataBase.getDatabase(this);
/*
        PitData pitData = new PitData("1","It looks good", , "Amazing!");


        SDB.pitDao().insertAll(pitData);


        */

        teams = SDB.pitDao().getTeams();

        int l = teams.size();

        Log.d("teams", String.valueOf(teams.size()));

        int exists = 0;


        for (int i = 0; i < l; i++ ){

           String z = teams.get(i);

           Log.d("teams", z);

           if(z.equals(String.valueOf(idInt))){
               exists = 1;
           }

        }


        if(exists == 1) {

            Log.d("PitView", "Returned List");
            pit = SDB.pitDao().findTeam(idInt);

            Log.d("pitdata", pit.getClass().getName());

            Log.d("pitviewdata", String.valueOf(pit.get(0).getBotInfo()));


            byte[] byteArray = pit.get(0).getImg_1();
            Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

            botThoughts.setText(String.valueOf(pit.get(0).getRobotThoughts()));
            botInfo.setText(String.valueOf(pit.get(0).getBotInfo()));
            Cycle.setText(String.valueOf(pit.get(0).getProjectedCycleTime()));
            climb.setText(String.valueOf(pit.get(0).getProjectedClimbLevel()));
            teamnum.setText(String.valueOf(pit.get(0).getTeamNum()));
            imageView.setImageBitmap(bitmap);

        }
        else{
            Toast.makeText(ActivityPitView.this, "Enter a valid TeamNumber!", Toast.LENGTH_LONG).show();;
        }


    }

    public void goHome(){
        Intent intent = new Intent(this, ActivityMain.class);
        startActivity(intent);

    }


}
