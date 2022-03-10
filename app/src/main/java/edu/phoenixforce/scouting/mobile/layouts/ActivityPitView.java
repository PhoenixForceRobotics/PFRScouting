package edu.phoenixforce.scouting.mobile.layouts;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
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
    TextView shower;

    String id;
    int idInt;

    private List<PitData> pit = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("ActivityPitView","onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pit_view);

        teamnum = findViewById(R.id.textView15);
        search = findViewById(R.id.button6);
        shower = findViewById(R.id.shower);

        search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("ActivityPitView","onClick");
                Log.d("ActivityPitView",
                id = teamnum.getText().toString());
                idInt = Integer.parseInt(id);
                Log.d("dataPull", "Ran searchData");
                searchData();

            }


        });

    }

    public void searchData(){
        Log.d("ActivityPitView", "searchData");

        ScoreDataBase SDB = ScoreDataBase.getDatabase(this);

        PitData pitData = new PitData("1","It looks good", "Amazing!");
        PitData pitData1 = new PitData("2", "It Looks decent", "red");

        SDB.pitDao().insertAll(pitData);
        SDB.pitDao().insertAll(pitData1);




        Log.d("PitView","Returned List");
        pit = SDB.pitDao().findTeam(idInt);

            Log.d("pitdata", pit.getClass().getName());

            Log.d("pitviewdata", String.valueOf(pit.get(0).getBotInfo()));





    }


}
