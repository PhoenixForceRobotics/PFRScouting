package edu.phoenixforce.scouting.mobile.layouts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
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

import android.widget.TextView;
import android.widget.Toast;

import com.example.fyrebirdscout11.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

//import static edu.phoenixforce.scouting.mobile.layouts.ConfigActivity.dEVNUM;
import static edu.phoenixforce.scouting.mobile.layouts.login.SHARED_PREFS;
import static edu.phoenixforce.scouting.mobile.layouts.login.TEXT;
import static edu.phoenixforce.scouting.mobile.layouts.team_select.matchNum;
import static edu.phoenixforce.scouting.mobile.layouts.team_select.teamNum;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import edu.phoenixforce.scouting.mobile.common.Constants;
import edu.phoenixforce.scouting.mobile.database.ScoreDataBase;


public class ActivityMain extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {
    private Button scores;
    private Button skipper;
    Button pitView;
    Button pitScout;
    //private Button rick;
    private Button choice, test;
    private FloatingActionButton fab;
    public String text ;
    public String dev, teamnum, match;

    public TextView user;
    public String userNombre;

    String buttonText = "Drive Coach";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        pitView = findViewById(R.id.pitViewButton);
        pitView.setText(buttonText);


        user = findViewById(R.id.textView17);
        test = findViewById(R.id.testBtn);


        SharedPreferences myPrefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = myPrefs.getString(TEXT, "No User");
        //dev = myPrefs.getString(dEVNUM, "Device Number Not Set");
        teamnum = myPrefs.getString(teamNum, "No Team Number" );

        match = myPrefs.getString(matchNum, "No Match Number");

        int role = myPrefs.getInt("state", 0);




        user.setText("Signed in as " + text + ". Is this you?");



        /*(Log.d("Night mode update", TeleScore.spunwheel + "" + TeleScore.counter4 + "" + String.valueOf(TeleScore.colorwheel)+ ""
                +String.valueOf(TeleScore.counter3) + TeleScore.colorwheel + "" + String.valueOf(TeleScore.spunwheel)+ "" + String.valueOf(TeleScore.solo)+ "" +
                String.valueOf(TeleScore.counter2) + "" + TeleScore.buddy + "" +
                String.valueOf(TeleScore.counter) + String.valueOf(TeleScore.balls) + String.valueOf(TeleScore.counter6) + String.valueOf(TeleScore.counter7)
                + String.valueOf(TeleScore.counter8) + String.valueOf(TeleScore.counter9) + String.valueOf(TeleScore.counter10));*/
        final ActivityMain thisActivity = this;


            skipper = (Button) findViewById(R.id.button2);
            skipper.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openTeleScore();
                }
            });


            scores = (Button) findViewById(R.id.button);
            if(role == 1){
                scores.setText("Start Pit Scouting!");
            }
            scores.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (role == 0) {
                        openAutoScore();
                    }
                    else if(role == 1){
                        pitNav(2);
                    }


            }
            });


            pitView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(text == "PitUser" | text == "Admin"){
                       pitNav(1);
                    }
                    else{
                        buttonText = ":(";
                        pitView.setText(buttonText);
                        Toast.makeText(ActivityMain.this, "Only For Use in the Pit!", Toast.LENGTH_LONG);
                        Log.v("PitAccess System", "Invalid click detected on pitview button");
                    }
                }
            });

            /*pitScout = findViewById(R.id.pitScoutButton);
            pitScout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {




                if(text == "PitUser" | text == "Admin"){
                    pitNav(2);
                }
                else{
                    Toast.makeText(ActivityMain.this, "Only For Use in the Pit!", Toast.LENGTH_LONG).show();
                }
        }
    });

             */

            test.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clearData();
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
                openQRCode();

                /*if (ContextCompat.checkSelfPermission(thisActivity, Manifest.permission.WRITE_EXTERNAL_STORAGE)
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

                 */
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

            Intent intent = new Intent(this, team_select.class);
            startActivity(intent);


        }
        public void openQRCode () {
            Intent intent = new Intent(this, QRCode.class);
            startActivity(intent);

        }

        public void openTeleScore () {

            Intent intent = new Intent(this, login.class);
            startActivity(intent);
        }
      private void openSettings () {

        if(text.equals("Admin")) {

            Intent intent = new Intent(this, ConfigActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Permission denied - 100 - ADMIN required", Toast.LENGTH_LONG).show();

        }

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

    public void clearData(){

        if(text.equals("Admin")) {

            ScoreDataBase SDB = ScoreDataBase.getDatabase(this);

            SDB.gameDao().nukeTable();

            Toast.makeText(this, "Table cleared", Toast.LENGTH_LONG).show();
            Log.v("ActivityMain", "Table Cleared");
        }

        else{
            Toast.makeText(this, "Permission denied - 100 - Must be run as ADMIN", Toast.LENGTH_LONG).show();
            Log.e("ActiivityMain", "Non-Admin tried to run clear data");

        }

    }

    @Override
    public void onBackPressed(){

        Toast.makeText(this, "You Cannot Return to the Previous Page", Toast.LENGTH_LONG).show();

    }

    public void pitNav(int button){

        if(button == 1){
            Intent intent = new Intent(this, ActivityPitView.class);
            startActivity(intent);
        }
        else if(button == 2){
            Intent intent = new Intent(this, ActivityPitScout.class);
            startActivity(intent);
        }


    }

}






