package edu.phoenixforce.scouting.mobile.layouts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.net.Uri;
import android.widget.TextView;

import com.example.fyrebirdscout11.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

//import static edu.phoenixforce.scouting.mobile.layouts.ConfigActivity.dEVNUM;
import static edu.phoenixforce.scouting.mobile.layouts.login.SHARED_PREFS;
import static edu.phoenixforce.scouting.mobile.layouts.login.TEXT;
import static edu.phoenixforce.scouting.mobile.layouts.team_select.matchNum;
import static edu.phoenixforce.scouting.mobile.layouts.team_select.teamNum;
import static java.sql.DriverManager.println;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Timer;
import java.util.TimerTask;

import edu.phoenixforce.scouting.mobile.common.Constants;
import edu.phoenixforce.scouting.mobile.database.ScoreDataBase;
import edu.phoenixforce.scouting.mobile.database.recyclervewveiwers.RecyclerViewViewer;


public class ActivityMain extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {
    private Button scores;
    private Button skipper;
    //private Button rick;
    private Button choice, test;
    private FloatingActionButton fab;
    public String text ;
    public String dev, teamnum, match;

    public TextView user;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        user = findViewById(R.id.textView17);
        test = findViewById(R.id.testBtn);

        SharedPreferences myPrefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = myPrefs.getString(TEXT, "No User");
        //dev = myPrefs.getString(dEVNUM, "Device Number Not Set");
        teamnum = myPrefs.getString(teamNum, "No Team Number" );

        match = myPrefs.getString(matchNum, "No Match Number");


        user.setText(text +  "Team " + teamnum + "Match " + match);



        Log.d("Night mode update", TeleScore.spunwheel + "" + TeleScore.counter4 + "" + String.valueOf(TeleScore.colorwheel)+ ""
                +String.valueOf(TeleScore.counter3) + TeleScore.colorwheel + "" + String.valueOf(TeleScore.spunwheel)+ "" + String.valueOf(TeleScore.solo)+ "" +
                String.valueOf(TeleScore.counter2) + "" + TeleScore.buddy + "" +
                String.valueOf(TeleScore.counter) + String.valueOf(TeleScore.balls) + String.valueOf(TeleScore.counter6) + String.valueOf(TeleScore.counter7)
                + String.valueOf(TeleScore.counter8) + String.valueOf(TeleScore.counter9) + String.valueOf(TeleScore.counter10));
        final ActivityMain thisActivity = this;


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

            test.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    seeData();
                }
            });


            choice = (Button) findViewById(R.id.options);
            choice.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    openSettings();
                }

            });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ContextCompat.checkSelfPermission(thisActivity, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {

                    if (ActivityCompat.shouldShowRequestPermissionRationale(thisActivity,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                        Snackbar.make(fab, "We can't copy the database without permission to store it to your external storage.",
                                Snackbar.LENGTH_INDEFINITE).setAction("Action", null).show();
                        // No explanation needed; request the permission
                        String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        ActivityCompat.requestPermissions(thisActivity, permissions, Constants.EXTERNAL_FILE_STORAGE_PERMISSION);

                    } else {
                        // No explanation needed; request the permission
                        String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        ActivityCompat.requestPermissions(thisActivity, permissions, Constants.EXTERNAL_FILE_STORAGE_PERMISSION);
                    }
                } else {
                    copyDatabase();
                }
            }
        });

        if (!Configuration.getInstance().isConfigured()) {
            Snackbar.make(fab, "Device has not yet been configured. Switching to config",
                    Snackbar.LENGTH_LONG).setAction("Action", null).show();
            openSettings();
        }
        }

        @Override
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
        }


    private void copyDatabase() {
        try
        {

            File sourceDb = new File(getApplicationContext().getDatabasePath(ScoreDataBase.DBNAME).getAbsolutePath());
            File targetDb = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/"
                    + ScoreDataBase.DBNAME + "_" + Configuration.getInstance().getTbaTeamId() + "_"
                    + Configuration.getInstance().getDeviceId() + ".db");

            FileInputStream fis = new FileInputStream(sourceDb);
            FileOutputStream fos = new FileOutputStream(targetDb);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer))>0){
                fos.write(buffer, 0, length);
            }

            // Close the streams
            fos.flush();
            fos.close();
            fis.close();

            Snackbar.make(this.findViewById(R.id.fab), "Copy complete.", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        }
        catch (Exception e) {
            Snackbar.make(findViewById(R.id.fab), "Exception copying data " + e.getMessage(), Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }


    }



    public void openAutoScore () {

            Intent intent = new Intent(this, TeleScore.class);
            startActivity(intent);


        }

        public void openTeleScore () {

            Intent intent = new Intent(this, login.class);
            startActivity(intent);
        }
      private void openSettings () {

        Intent intent = new Intent(this,  ConfigActivity.class);
        startActivity(intent);

        }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case Constants.EXTERNAL_FILE_STORAGE_PERMISSION:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    copyDatabase();
                }
                else{
                    //Denied.
                }
                break;
        }
    }

    public void seeData(){

        Intent intent = new Intent(this,  RecyclerViewViewer.class);
        startActivity(intent);

    }

}






