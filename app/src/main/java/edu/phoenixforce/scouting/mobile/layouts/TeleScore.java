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

public class TeleScore extends AppCompatActivity {


    //Counters
    TextView cone_counter1;
    TextView cone_counter2;
    TextView cone_counter3;
    TextView cube_counter1;
    TextView cube_counter2;
    TextView cube_counter3;
    TextView team_number_tele;
    TextView defense_counter;


    //Checkboxs
    CheckBox check1_broke;
    CheckBox check2_drove;
    CheckBox check3_show;
    CheckBox check4_onstation;
    CheckBox check5_level;


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
    int check_counter4;
    int check_counter5;


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

        team_number_tele = findViewById(R.id.team_number_tele);
        team_number_tele.setText(String.valueOf(teamNum));

        defense_counter = findViewById(R.id.defense_counter);


        //Checkboxs

        check2_drove = findViewById(R.id.check2_drove);
        check3_show = findViewById(R.id.check3_show);
        check4_onstation = findViewById(R.id.check4_onstation);
        check5_level = findViewById(R.id.check5_levelonstation);

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

        defense_Plus1 = findViewById(R.id.defense_Plus1);
        defense_Minus1 = findViewById(R.id.defense_Minus1);
        finish_Button = findViewById(R.id.finish_button);

        //Set up

        cone_counter1.setText("0");
        cone_counter2.setText("0");
        cone_counter3.setText("0");

        cube_counter1.setText("0");
        cube_counter2.setText("0");
        cube_counter3.setText("0");

        defense_counter.setText("0");

        SharedPreferences scorePrefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        Constants constants = new Constants();
        constants.getPrefs(this);
        String tNumber = scorePrefs.getString(teamNum, "0");

        //CheckBox's
        //Might need to be a string instead of an int - as in past apps
        check1_broke = findViewById(R.id.check1_broke);
        check1_broke.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                                    @Override
                                                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                                                        if (isChecked) {
                                                            check_counter1 = 1;
                                                            Log.d("check1", "ran");
                                                        } else {
                                                            check_counter1 = 0;
                                                        }
                                                    }

                                                }
        );

        check2_drove.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    check_counter2 = 1;
                    Log.d("check2", "ran");
                } else {
                    check_counter2 = 0;
                }
            }

        });

        check3_show.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    check_counter3 = 1;
                    Log.d("check3", "ran");
                } else {
                    check_counter3 = 0;
                }
            }

        });
        check4_onstation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    check_counter4 = 1;
                    Log.d("check3", "ran");
                } else {
                    check_counter4 = 0;
                }
            }

        });
        check5_level.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    check_counter5 = 1;
                    Log.d("check3", "ran");
                } else {
                    check_counter5 = 0;
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
                if (Ocounter1 < 1) {
                } else {
                    Ocounter1 = Ocounter1 - 1;

                }
                cone_counter1.setText(String.valueOf(Ocounter1));


            }
        });

        cone_Minus2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (Ocounter2 < 1) {
                } else {
                    Ocounter2 = Ocounter2 - 1;

                }
                cone_counter2.setText(String.valueOf(Ocounter2));


            }
        });

        cone_Minus3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (Ocounter3 < 1) {
                } else {
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
                if (Ucounter1 < 1) {
                } else {
                    Ucounter1 = Ucounter1 - 1;

                }
                cube_counter1.setText(String.valueOf(Ucounter1));


            }
        });

        cube_Minus2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (Ucounter2 < 1) {
                } else {
                    Ucounter2 = Ucounter2 - 1;

                }
                cube_counter2.setText(String.valueOf(Ucounter2));


            }
        });

        cube_Minus3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (Ucounter3 < 1) {
                } else {
                    Ucounter3 = Ucounter3 - 1;

                }
                cube_counter3.setText(String.valueOf(Ucounter3));


            }
        });
        // Defense Plus and Minus

        defense_Plus1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (Dcounter1 < 5)
                    Dcounter1 = Dcounter1 + 1;
                defense_counter.setText(String.valueOf(Dcounter1));


            }
        });

        defense_Minus1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (Dcounter1 < 1) {
                } else {
                    Dcounter1 = Dcounter1 - 1;

                }
                defense_counter.setText(String.valueOf(Dcounter1));


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

    public void navigate() {

        saveGameData();
        Intent intent = new Intent(this, ActivityMain.class);
        startActivity(intent);


    }


    public void saveGameData() {

        ScoreDataBase SDB = ScoreDataBase.getDatabase(this);

        //  GameData gameData = new GameData(constants.getUser(),"2","3","4", "5", "6", "7", "8", "9"
        //        , "10", "11", "12", "13", "14", "15", "16");

        SharedPreferences scorePrefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        Constants constants = new Constants();
        constants.getPrefs(this);
        String teamNum2 = scorePrefs.getString(teamNum, "0");
        String matchNum2 = scorePrefs.getString(matchNum, "0");
        String scout2 = scorePrefs.getString(TEXT, "0");
        String autoMoved1 = scorePrefs.getString("Moved","0");
        String levelOnChargeStation1 = scorePrefs.getString("LevelOnChargeStation","0");
        String notLevelOnStation1 = scorePrefs.getString("NotLevelOnChargeStation","0");
        String leftCommunity1 = scorePrefs.getString("LeftCommunity","0");
        String box1 = scorePrefs.getString("checkBox1", "0");
        String box2 = scorePrefs.getString("checkBox2", "0");
        String box3 = scorePrefs.getString("checkBox3", "0");
        String box4 = scorePrefs.getString("checkBox4", "0");
        String box5 = scorePrefs.getString("checkBox5", "0");
        String box6 = scorePrefs.getString("checkBox6", "0");
        String box7 = scorePrefs.getString("checkBox7", "0");
        String box8 = scorePrefs.getString("checkBox8", "0");
        String box9 = scorePrefs.getString("checkBox9", "0");
        String box10 = scorePrefs.getString("checkBox10", "0");
        String box11 = scorePrefs.getString("checkBox11", "0");
        String box12 = scorePrefs.getString("checkBox12", "0");
        String box13 = scorePrefs.getString("checkBox13", "0");
        String box14 = scorePrefs.getString("checkBox14", "0");
        String box15 = scorePrefs.getString("checkBox15", "0");
        String box16 = scorePrefs.getString("checkBox16", "0");
        String box17 = scorePrefs.getString("checkBox17", "0");
        String box18 = scorePrefs.getString("checkBox18", "0");
        String box19 = scorePrefs.getString("checkBox19", "0");
        String box20 = scorePrefs.getString("checkBox20", "0");
        String box21 = scorePrefs.getString("checkBox21", "0");
        String box22 = scorePrefs.getString("checkBox22", "0");
        String box23 = scorePrefs.getString("checkBox23", "0");
        String box24 = scorePrefs.getString("checkBox24", "0");
        String box25 = scorePrefs.getString("checkBox25", "0");
        String box26 = scorePrefs.getString("checkBox26", "0");
        String box27 = scorePrefs.getString("checkBox27", "0");











        //Ints to Strings
        String Ocounter1S = String.valueOf(Ocounter1);
        String Ocounter2S = String.valueOf(Ocounter2);
        String Ocounter3S = String.valueOf(Ocounter3);

        String Ucounter1S = String.valueOf(Ucounter1);
        String Ucounter2S = String.valueOf(Ucounter2);
        String Ucounter3S = String.valueOf(Ucounter3);

        String Dcounter1S = String.valueOf(Dcounter1);

        String check_counter1S = String.valueOf(check_counter1);
        String check_counter2S = String.valueOf(check_counter2);
        String check_counter3S = String.valueOf(check_counter3);
        String check_counter4S = String.valueOf(check_counter4);
        String check_counter5S = String.valueOf(check_counter5);

//Game Data
        GameData gameData = new GameData(scout2, String.valueOf(constants.getDeviceId()), matchNum2, teamNum2,
                Ocounter1S, Ocounter2S, Ocounter3S, Ucounter1S, Ucounter2S, Ucounter3S,
                Dcounter1S, autoMoved1, leftCommunity1, notLevelOnStation1,
                levelOnChargeStation1, check_counter4S, check_counter5S, check_counter2S,
                check_counter1S, check_counter3S, box19, box20, box21, box22,
                box23, box24, box25, box26, box27, box10, box11,
                box12, box13, box14, box15, box16, box17, box18,
                box1, box2, box3, box4, box5, box6, box7,
                box8, box9);

        SDB.gameDao().insertAll(gameData);








    }
}