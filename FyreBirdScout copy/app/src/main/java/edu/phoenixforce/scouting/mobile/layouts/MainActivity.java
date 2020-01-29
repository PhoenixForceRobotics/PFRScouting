package edu.phoenixforce.scouting.mobile.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.net.Uri;

import com.example.fyrebirdscout11.R;


public class MainActivity extends AppCompatActivity {
    private Button scores;
    private Button skipper;
    private Button rick;
    private Button choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        skipper = (Button) findViewById(R.id.button2);
        skipper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTeleScore();
            }
        });


        scores = (Button) findViewById(R.id.button);
        scores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAutoScore();
            }
        });

        rick = (Button) findViewById(R.id.rickroll);
        rick.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
                startActivity(browserIntent);


                //The only point of this is for Rick Astley to play

            }

        });
        choice = (Button) findViewById(R.id.options);
        choice.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                openSettings();
            }

        });

    }
        public void openAutoScore () {

            Intent intent = new Intent(this, AutoScore.class);
            startActivity(intent);


        }

        public void openTeleScore () {

            Intent intent = new Intent(this, TeleScore.class);
            startActivity(intent);
        }
        public void openSettings () {

        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);

        }
    }


