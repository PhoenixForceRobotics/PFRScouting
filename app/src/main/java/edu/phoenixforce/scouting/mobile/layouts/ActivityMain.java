package edu.phoenixforce.scouting.mobile.layouts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.net.Uri;

import com.example.fyrebirdscout11.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import static java.sql.DriverManager.println;

import java.util.Timer;
import java.util.TimerTask;



public class ActivityMain extends AppCompatActivity {
    private Button scores;
    private Button skipper;
    private Button rick;
    private Button choice;
    private FloatingActionButton fab;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        //BROKENPART
        /*Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

      /* fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
      /* if (!Configuration.getInstance().isConfigured()) {
           Snackbar.make(fab, "Device has not yet been configured. Switching to config",
                   Snackbar.LENGTH_LONG).setAction("Action", null).show();
           openSettings();
       }*/

            //existing
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


            choice = (Button) findViewById(R.id.options);
            choice.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    openSettings();
                }

            });


        }

       /* @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                openSettings();
                return true;
            }

            return super.onOptionsItemSelected(item);
        }*/



        public void openAutoScore () {

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);


        }

        public void openTeleScore () {

            Intent intent = new Intent(this, TeleScore.class);
            startActivity(intent);
        }
      private void openSettings () {

        Intent intent = new Intent(this,  ConfigActivity.class);
        startActivity(intent);

        }}






