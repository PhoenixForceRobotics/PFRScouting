package edu.phoenixforce.scouting.mobile.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;


import com.example.fyrebirdscout11.R;

import edu.phoenixforce.scouting.mobile.database.ScoreDataBase;
import edu.phoenixforce.scouting.mobile.database.entities.GameData;
import edu.phoenixforce.scouting.mobile.database.entities.TeleData;
import edu.phoenixforce.scouting.mobile.functions.Timer;
import edu.phoenixforce.scouting.mobile.common.*;
import static edu.phoenixforce.scouting.mobile.layouts.login.SHARED_PREFS;
import static edu.phoenixforce.scouting.mobile.layouts.login.TEXT;
import static edu.phoenixforce.scouting.mobile.layouts.login.text;
import static edu.phoenixforce.scouting.mobile.layouts.team_select.matchNum;
import static edu.phoenixforce.scouting.mobile.layouts.team_select.teamNum;

public class TeleScore extends AppCompatActivity{


    //Counters
    TextView cone_counter1;
    TextView cone_counter2;
    TextView cone_counter3;
    TextView cube_counter1;
    TextView cube_counter2;
    TextView cube_counter3;


    //Checkboxs
    CheckBox check1_broke;
    CheckBox check2_drove;
    CheckBox check3_show;


    //Buttons
    Button cone_Plus1;
    Button cone_Plus2;
    Button cone_Plus3;

    Button cone_Minus1;
    Button cone_Minus2;
    Button cone_Minus3;

    Button cube_Plus1;
    Button cube_Plus2;
    Button cube_Plus3;

    Button cube_Minus1;
    Button cube_Minus2;
    Button cube_Minus3;


    Button defense_Plus1;
    Button defense_Minus1;
    Button finish_Button;

    //integers
    // U counter =  Cube Counter
    int Ucounter1;
    int Ucounter2;
    int Ucounter3;
    // U counter =  Cone Counter
    int Ocounter1;
    int Ocounter2;
    int Ocounter3;
    // D counter =  Defense Counter
    int Dcounter1;
    //Check Counters
    int check_counter1;
    int check_counter2;
    int check_counter3;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tele_score);

        //TextViews
        cone_counter1 = findViewById(R.id.cone_counter1);
        cone_counter2 = findViewById(R.id.cone_counter2);
        cone_counter3 = findViewById(R.id.cone_counter3);

        cube_counter1 = findViewById(R.id.cube_counter1);
        cube_counter2 = findViewById(R.id.cube_counter2);
        cube_counter3 = findViewById(R.id.cube_counter3);

        //Checkboxs
        check1_broke = findViewById(R.id.check1_broke);
        check2_drove = findViewById(R.id.check2_drove);
        check3_show = findViewById(R.id.check3_show);

        //Buttons
        cone_Minus1 = findViewById(R.id.cone_minus1);
        cone_Minus2 = findViewById(R.id.cone_minus2);
        cone_Minus3 = findViewById(R.id.cone_minus3);

        cone_Plus1 = findViewById(R.id.cone_plus1);
        cone_Plus2 = findViewById(R.id.cone_plus2);
        cone_Plus3 = findViewById(R.id.cone_plus3);

        cube_Minus1 = findViewById(R.id.cube_minus1);
        cube_Minus2 = findViewById(R.id.cube_minus2);
        cube_Minus3 = findViewById(R.id.cube_minus3);

        cube_Plus1 = findViewById(R.id.cube_plus1);
        cube_Plus2 = findViewById(R.id.cube_plus2);
        cube_Plus3 = findViewById(R.id.cube_plus3);

        defense_Plus1 = findViewById(R.id.defense_plus1);
        defense_Minus1 = findViewById(R.id.defense_plus1);
        finish_Button = findViewById(R.id.finish_button);

        //Set up

        cone_counter1.setText("0");
        cone_counter2.setText("0");
        cone_counter3.setText("0");

        cube_counter1.setText("0");
        cube_counter2.setText("0");
        cube_counter3.setText("0");



        //CheckBox's
        //Might need to be a string instead of an int - as in past apps

        check1_broke.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if( isChecked){
                    check_counter1 = 1;
                    Log.d("check1", "ran");
                }
                else {
                    check_counter1 = 0;
                }
            }

        });

        check2_drove.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if( isChecked){
                    check_counter2 = 1;
                    Log.d("check2", "ran");
                }
                else {
                    check_counter2 = 0;
                }
            }

        });

        check3_show.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if( isChecked){
                    check_counter3 = 1;
                    Log.d("check3", "ran");
                }
                else {
                    check_counter3 = 0;
                }
            }

        });

        //Programing Buttons on click (set on click listeners)
        //Plus buttons for cones

        cone_Plus1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Ocounter1 = Ocounter1 + 1;
                cone_counter1.setText(String.valueOf(Ocounter1));


            }
        });

        cone_Plus2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Ocounter2 = Ocounter2 + 1;
                cone_counter2.setText(String.valueOf(Ocounter2));


            }
        });

        cone_Plus3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Ocounter3 = Ocounter3 + 1;
                cone_counter3.setText(String.valueOf(Ocounter3));


            }
        });

        //Minus buttons for Cones

        cone_Minus1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (Ocounter1 < 1){
                }
                else {
                    Ocounter1 = Ocounter1 - 1;

                }
                cone_counter1.setText(String.valueOf(Ocounter1));


            }
        });

        cone_Minus2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (Ocounter2 < 1){
                }
                else {
                    Ocounter2 = Ocounter2 - 1;

                }
                cone_counter2.setText(String.valueOf(Ocounter2));


            }
        });

        cone_Minus3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (Ocounter3 < 1){
                }
                else {
                    Ocounter3 = Ocounter3 - 1;

                }
                cone_counter3.setText(String.valueOf(Ocounter3));


            }
        });

        //Plus Buttons for Cubes

        cube_Plus1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Ucounter1 = Ucounter1 + 1;
                cube_counter1.setText(String.valueOf(Ucounter1));


            }
        });

        cube_Plus2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Ucounter2 = Ucounter2 + 1;
                cube_counter2.setText(String.valueOf(Ucounter2));


            }
        });

        cube_Plus3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Ucounter3 = Ucounter3 + 1;
                cube_counter3.setText(String.valueOf(Ucounter3));


            }
        });

        //Minus Buttons for Cubes

        cube_Minus1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (Ucounter1 < 1){
                }
                else {
                    Ucounter1 = Ucounter1 - 1;

                }
                cube_counter1.setText(String.valueOf(Ucounter1));


            }
        });

        cube_Minus2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (Ucounter2 < 1){
                }
                else {
                    Ucounter2 = Ucounter2 - 1;

                }
                cube_counter2.setText(String.valueOf(Ucounter2));


            }
        });

        cube_Minus3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (Ucounter3 < 1){
                }
                else {
                    Ucounter3 = Ucounter3 - 1;

                }
                cube_counter3.setText(String.valueOf(Ucounter3));


            }
        });

        //Finish button
        finish_Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                navigate();

            }

        });




    }
    public void navigate(){

        Intent intent = new Intent(this, ActivityMain.class);
        startActivity(intent);


    }
}