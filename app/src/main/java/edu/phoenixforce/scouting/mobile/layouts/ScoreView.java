package edu.phoenixforce.scouting.mobile.layouts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fyrebirdscout11.R;

import edu.phoenixforce.scouting.mobile.database.ScoreDataBase;

public class ScoreView extends AppCompatActivity {

RecyclerView recyclerView;
RecyclerView.Adapter adapter;

Button deleter;

//List<Scores> ascores;


@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_view);

        recyclerView = findViewById(R.id.recyclerview);
        deleter = findViewById(R.id.button5);

       /* Scores = new ArrayList<>();

        for (int i = 0; i < 100; i++){
            Scores ascores = new Scores("1" + i,"1", "1", "1", "1", "1", "ANDREW");
            Scores.add(ascores);

        }

        */
    ScoreDataBase db = Room.databaseBuilder(getApplicationContext(), ScoreDataBase.class, "production")
            .allowMainThreadQueries()
            .build();


    //List<Scores> ascores = db.ballDao().getAllScores();
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    //adapter = new BallScoreAdapter(ascores);
    recyclerView.setAdapter(adapter);


 deleter.setOnClickListener(new View.OnClickListener(){

    @Override
    public void onClick(View v){

       // db.ballDao().nukeTable();




    }

});











}







}

