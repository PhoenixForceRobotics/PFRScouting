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





        Checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if( isChecked){
                    CheckBox1 = "1";
                    Log.d("counter", "ran");
                }
                else {
                    CheckBox1 = "0";
                }
            }

        }
        );

        Checkbox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if( isChecked){
                    CheckBox2 = "1";
                    Log.d("counter", "ran");

                }
                else {
                    CheckBox2 = "0";
                }
            }

        }
        );

        Checkbox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if( isChecked){
                    CheckBox3 = "1";
                    Log.d("counter", "ran");

                }
                else {
                    CheckBox3 = "0";

                }
            }

        }
        );

        Checkbox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if( isChecked){
                    CheckBox4 = "1";
                    Log.d("counter", "ran");

                }
                else {
                    CheckBox4 = "0";

                }
            }

        }
        );

        Checkbox5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if( isChecked){
                    CheckBox5 = "1";
                    Log.d("counter", "ran");

                }
                else {
                    CheckBox5 = "0";

                }
            }

        }
        );

        Checkbox6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if( isChecked){
                    CheckBox6 = "1";
                    Log.d("counter", "ran");

                }
                else {
                    CheckBox6 = "0";

                }
            }

        }
        );

        Checkbox7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if( isChecked){
                    CheckBox7 = "1";
                    Log.d("counter", "ran");

                }
                else {
                    CheckBox7 = "0";

                }
            }

        }
        );

        Checkbox8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if( isChecked){
                    CheckBox8 = "1";
                    Log.d("counter", "ran");

                }
                else {
                    CheckBox8 = "0";

                }
            }

        }
        );

        Checkbox9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if( isChecked){
                    CheckBox9 = "1";
                    Log.d("counter", "ran");

                }
                else {
                    CheckBox9 = "0";

                }
            }

        }
        );

        Checkbox10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if( isChecked){
                    CheckBox10 = "1";
                    Log.d("counter", "ran");

                }
                else {
                    CheckBox10 = "0";

                }
            }

        }
        );

        Checkbox11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if( isChecked){
                    CheckBox11 = "1";
                    Log.d("counter", "ran");

                }
                else {
                    CheckBox11 = "0";

                }
            }

        }
        );

        Checkbox12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if( isChecked){
                    CheckBox12 = "1";
                    Log.d("counter", "ran");

                }
                else {
                    CheckBox12 = "0";

                }
            }

        }
        );

        Checkbox13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if( isChecked){
                    CheckBox13 = "1";
                    Log.d("counter", "ran");

                }
                else {
                    CheckBox13 = "0";

                }
            }

        }
        );

        Checkbox14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if( isChecked){
                    CheckBox14 = "1";
                    Log.d("counter", "ran");

                }
                else {
                    CheckBox14 = "0";

                }
            }

        }
        );

        Checkbox15.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if( isChecked){
                    CheckBox15 = "1";
                    Log.d("counter", "ran");

                }
                else {
                    CheckBox15 = "0";

                }
            }

        }
        );

        Checkbox16.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if( isChecked){
                    CheckBox16 = "1";
                    Log.d("counter", "ran");

                }
                else {
                    CheckBox16 = "0";

                }
            }

        }
        );

        Checkbox17.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if( isChecked){
                    CheckBox17 = "1";
                    Log.d("counter", "ran");

                }
                else {
                    CheckBox17 = "0";

                }
            }

        }
        );

        Checkbox18.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if( isChecked){
                    CheckBox18 = "1";
                    Log.d("counter", "ran");

                }
                else {
                    CheckBox18 = "0";

                }
            }

        }
        );

        Checkbox19.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if( isChecked){
                    CheckBox19 = "1";
                    Log.d("counter", "ran");

                }
                else {
                    CheckBox19 = "0";

                }
            }

        }
        );

        Checkbox20.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if( isChecked){
                    CheckBox20 = "1";
                    Log.d("counter", "ran");

                }
                else {
                    CheckBox20 = "0";

                }
            }

        }
        );

        Checkbox21.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if( isChecked){
                    CheckBox21 = "1";
                    Log.d("counter", "ran");

                }
                else {
                    CheckBox21 = "0";

                }
            }

        }
        );

        Checkbox22.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if( isChecked){
                    CheckBox22 = "1";
                    Log.d("counter", "ran");

                }
                else {
                    CheckBox22 = "0";

                }
            }

        }
        );

        Checkbox23.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if( isChecked){
                    CheckBox23 = "1";
                    Log.d("counter", "ran");

                }
                else {
                    CheckBox23 = "0";

                }
            }

        }
        );

        Checkbox24.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if( isChecked){
                    CheckBox24 = "1";
                    Log.d("counter", "ran");

                }
                else {
                    CheckBox24 = "0";

                }
            }

        }
        );

        Checkbox25.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if( isChecked){
                    CheckBox25 = "1";
                    Log.d("counter", "ran");

                }
                else {
                    CheckBox25 = "0";

                }
            }

        }
        );

        Checkbox26.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if( isChecked){
                    CheckBox26 = "1";
                    Log.d("counter", "ran");

                }
                else {
                    CheckBox26 = "0";

                }
            }

        }
        );

        Checkbox27.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if( isChecked){
                    CheckBox27 = "1";
                    Log.d("counter", "ran");

                }
                else {
                    CheckBox27 = "0";

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


        String checkBox1 = String.valueOf(Checkbox1);
        String checkBox2 = String.valueOf(Checkbox2);
        String checkBox3 = String.valueOf(Checkbox3);
        String checkBox4 = String.valueOf(Checkbox4);
        String checkBox5 = String.valueOf(Checkbox5);
        String checkBox6 = String.valueOf(Checkbox6);
        String checkBox7 = String.valueOf(Checkbox7);
        String checkBox8 = String.valueOf(Checkbox8);
        String checkBox9 = String.valueOf(Checkbox9);
        String checkBox10 = String.valueOf(Checkbox10);
        String checkBox11 = String.valueOf(Checkbox11);
        String checkBox12 = String.valueOf(Checkbox12);
        String checkBox13 = String.valueOf(Checkbox13);
        String checkBox14 = String.valueOf(Checkbox14);
        String checkBox15 = String.valueOf(Checkbox15);
        String checkBox16 = String.valueOf(Checkbox16);
        String checkBox17 = String.valueOf(Checkbox17);
        String checkBox18 = String.valueOf(Checkbox18);
        String checkBox19 = String.valueOf(Checkbox19);
        String checkBox20 = String.valueOf(Checkbox20);
        String checkBox21 = String.valueOf(Checkbox21);
        String checkBox22 = String.valueOf(Checkbox22);
        String checkBox23 = String.valueOf(Checkbox23);
        String checkBox24 = String.valueOf(Checkbox24);
        String checkBox25 = String.valueOf(Checkbox25);
        String checkBox26 = String.valueOf(Checkbox26);
        String checkBox27 = String.valueOf(Checkbox27);




        editorTwo.putString("autoMoved", counter5);
        editorTwo.putString("autoMoved", checkBox1);
        editorTwo.putString("autoMoved", checkBox2);
        editorTwo.putString("autoMoved", checkBox3);
        editorTwo.putString("autoMoved", checkBox4);
        editorTwo.putString("autoMoved", checkBox5);
        editorTwo.putString("autoMoved", checkBox6);
        editorTwo.putString("autoMoved", checkBox7);
        editorTwo.putString("autoMoved", checkBox8);
        editorTwo.putString("autoMoved", checkBox9);
        editorTwo.putString("autoMoved", checkBox10);
        editorTwo.putString("autoMoved", checkBox11);
        editorTwo.putString("autoMoved", checkBox12);
        editorTwo.putString("autoMoved", checkBox13);
        editorTwo.putString("autoMoved", checkBox14);
        editorTwo.putString("autoMoved", checkBox15);
        editorTwo.putString("autoMoved", checkBox16);
        editorTwo.putString("autoMoved", checkBox17);
        editorTwo.putString("autoMoved", checkBox18);
        editorTwo.putString("autoMoved", checkBox19);
        editorTwo.putString("autoMoved", checkBox20);
        editorTwo.putString("autoMoved", checkBox21);
        editorTwo.putString("autoMoved", checkBox22);
        editorTwo.putString("autoMoved", checkBox23);
        editorTwo.putString("autoMoved", checkBox24);
        editorTwo.putString("autoMoved", checkBox25);
        editorTwo.putString("autoMoved", checkBox26);
        editorTwo.putString("autoMoved", checkBox27);


        editorTwo.apply();

        Log.d("auto", String.valueOf(counter5));

        Intent intent = new Intent(this, TeleScore.class);
        startActivity(intent);


    }


}
