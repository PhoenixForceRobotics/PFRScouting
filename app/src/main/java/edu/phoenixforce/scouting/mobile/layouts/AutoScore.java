package edu.phoenixforce.scouting.mobile.layouts;

import static edu.phoenixforce.scouting.mobile.layouts.login.SHARED_PREFS;
import static edu.phoenixforce.scouting.mobile.layouts.team_select.matchNum;
import static edu.phoenixforce.scouting.mobile.layouts.team_select.teamNum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.widget.CheckBox;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
//import android.widget.CheckBox; -- Not needed during the auto period
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fyrebirdscout11.R;
import com.google.android.material.chip.ChipGroup;

import edu.phoenixforce.scouting.mobile.common.Constants;
import edu.phoenixforce.scouting.mobile.database.ScoreDataBase;


public class AutoScore<Moved> extends AppCompatActivity {

    Constants constants = new Constants();

    //CheckBoxes
    CheckBox Checkbox1;
    CheckBox Checkbox2;
    CheckBox Checkbox3;
    CheckBox Checkbox4;
    CheckBox Checkbox5;
    CheckBox Checkbox6;
    CheckBox Checkbox7;
    CheckBox Checkbox8;
    CheckBox Checkbox9;
    CheckBox Checkbox10;
    CheckBox Checkbox11;
    CheckBox Checkbox12;
    CheckBox Checkbox13;
    CheckBox Checkbox14;
    CheckBox Checkbox15;
    CheckBox Checkbox16;
    CheckBox Checkbox17;
    CheckBox Checkbox18;
    CheckBox Checkbox19;
    CheckBox Checkbox20;
    CheckBox Checkbox21;
    CheckBox Checkbox22;
    CheckBox Checkbox23;
    CheckBox Checkbox24;
    CheckBox Checkbox25;
    CheckBox Checkbox26;
    CheckBox Checkbox27;
    CheckBox Moved;
    CheckBox LeftCommunity;
    CheckBox LevelOnChargeStation;
    CheckBox NotLevelOnChargeStation;






    CheckBox checkBox;


    //Buttons

    Button finishButton;

    String counter5 = "0";
    String CheckBox1 = "0";
    String CheckBox2 = "0";
    String CheckBox3 = "0";
    String CheckBox4 = "0";
    String CheckBox5 = "0";
    String CheckBox6 = "0";
    String CheckBox7 = "0";
    String CheckBox8 = "0";
    String CheckBox9 = "0";
    String CheckBox10 = "0";
    String CheckBox11 = "0";
    String CheckBox12 = "0";
    String CheckBox13 = "0";
    String CheckBox14 = "0";
    String CheckBox15 = "0";
    String CheckBox16 = "0";
    String CheckBox17 = "0";
    String CheckBox18 = "0";
    String CheckBox19 = "0";
    String CheckBox20 = "0";
    String CheckBox21 = "0";
    String CheckBox22 = "0";
    String CheckBox23 = "0";
    String CheckBox24 = "0";
    String CheckBox25 = "0";
    String CheckBox26 = "0";
    String CheckBox27 = "0";
    String GetMoved = "0";
    String GetLeftCommunity = "0";
    String GetLevelOnChargeStation = "0";
    String GetMovedNotLevelOnChargeStation = "0";



    public static String team;
    public static int teamnumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_score);

        Constants constants = new Constants();


        //TextViews



        //Buttons



        finishButton = findViewById(R.id.finishedbutton);
        Checkbox1 = findViewById(R.id.Checkbox1);
        Checkbox2 = findViewById(R.id.Checkbox2);
        Checkbox3  = findViewById(R.id.Checkbox3);
        Checkbox4 = findViewById(R.id.Checkbox4);
        Checkbox5 = findViewById(R.id.Checkbox5);
        Checkbox6 = findViewById(R.id.Checkbox6);
        Checkbox7 = findViewById(R.id.Checkbox7);
        Checkbox8 = findViewById(R.id.Checkbox8);
        Checkbox9 = findViewById(R.id.Checkbox9);
        Checkbox10 = findViewById(R.id.Checkbox10);
        Checkbox11 = findViewById(R.id.Checkbox11);
        Checkbox12 = findViewById(R.id.Checkbox12);
        Checkbox13 = findViewById(R.id.Checkbox13);
        Checkbox14 = findViewById(R.id.Checkbox14);
        Checkbox15 = findViewById(R.id.Checkbox15);
        Checkbox16 = findViewById(R.id.Checkbox16);
        Checkbox17 = findViewById(R.id.Checkbox17);
        Checkbox18 = findViewById(R.id.Checkbox18);
        Checkbox19 = findViewById(R.id.Checkbox19);
        Checkbox20 = findViewById(R.id.Checkbox20);
        Checkbox21 = findViewById(R.id.Checkbox21);
        Checkbox22 = findViewById(R.id.Checkbox22);
        Checkbox23 = findViewById(R.id.Checkbox23);
        Checkbox24 = findViewById(R.id.Checkbox24);
        Checkbox25 = findViewById(R.id.Checkbox25);
        Checkbox27 = findViewById(R.id.Checkbox26);
        Moved = findViewById(R.id.Moved);
        LeftCommunity = findViewById(R.id.LeftCommunity);
        LevelOnChargeStation = findViewById(R.id.LevelOnChargeStation);
        NotLevelOnChargeStation = findViewById(R.id.NotLevelOnChargeStation);



        //Top text box
        SharedPreferences scorePrefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editorTwo = scorePrefs.edit();


        SharedPreferences myPrefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);


        team = myPrefs.getString(teamNum, "No Match Number");

        teamnumber = Integer.valueOf(team);

        //todo Rename reassurance
        //on app launch Text View Must show zero



/*                backA.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        openMainActivity();

                    }
                });

 */





        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if( isChecked){
                    counter5 = "1";
                    Log.d("counter", "ran");
                }
                else {
                    counter5 = "0";
                }
            }

        }
        );



        //upbuttons
        finishButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                navigate();

            }

        });


    }


    public void navigate() {

        SharedPreferences scorePrefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editorTwo = scorePrefs.edit();


        editorTwo.putString("autoMoved", counter5);

        editorTwo.apply();

        Log.d("auto", String.valueOf(counter5));

        Intent intent = new Intent(this, TeleScore.class);
        startActivity(intent);


    }


}
