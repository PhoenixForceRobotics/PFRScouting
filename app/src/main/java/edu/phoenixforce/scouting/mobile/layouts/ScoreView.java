package edu.phoenixforce.scouting.mobile.layouts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fyrebirdscout11.R;

import java.util.ArrayList;
import java.util.List;

import edu.phoenixforce.scouting.mobile.database.BallScoreAdapter;
import edu.phoenixforce.scouting.mobile.database.ScoreDataBase;
import edu.phoenixforce.scouting.mobile.database.ScoreDataBase_Impl;
import edu.phoenixforce.scouting.mobile.database.Scores;

public class ScoreView extends AppCompatActivity {

RecyclerView recyclerView;
RecyclerView.Adapter adapter;

Button deleter;

//ArrayList<Scores> scores;


@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_view);

        recyclerView = findViewById(R.id.recyclerview);
        deleter = findViewById(R.id.button5);

       /* scores = new ArrayList<>();

        for (int i = 0; i < 100; i++){
            Scores ascores = new Scores("1" + i,"1", "1", "1", "1", "1", "ANDREW");
            scores.add(ascores);

        }

        */
    ScoreDataBase db = Room.databaseBuilder(getApplicationContext(), ScoreDataBase.class, "production")
            .allowMainThreadQueries()
            .build();

deleter.setOnClickListener(new View.OnClickListener(){

    @Override
    public void onClick(View v){

        db.ballDao().nukeTable();




    }

});






  List<Scores> ascores = db.ballDao().getAllData();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BallScoreAdapter(ascores);
        recyclerView.setAdapter(adapter);




}







}

