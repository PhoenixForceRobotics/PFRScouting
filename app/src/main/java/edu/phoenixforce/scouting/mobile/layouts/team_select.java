package edu.phoenixforce.scouting.mobile.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fyrebirdscout11.R;

public class team_select extends AppCompatActivity {

    Button finished;

    TextView match;

    String matchNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_select);

        finished = findViewById(R.id.goScout);
        match = findViewById(R.id.matchNum);
        matchNumber = match.getText().toString();

        finished.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                goScore();


            }});


    }

    public void goScore(){

        Intent intent = new Intent(this, ActivityMain.class);
        startActivity(intent);

    }
}

