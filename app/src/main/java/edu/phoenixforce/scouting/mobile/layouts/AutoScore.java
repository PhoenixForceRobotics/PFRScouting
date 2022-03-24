package edu.phoenixforce.scouting.mobile.layouts;

import static edu.phoenixforce.scouting.mobile.layouts.login.SHARED_PREFS;

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


public class AutoScore extends AppCompatActivity {

    Constants constants = new Constants();

    private static final String CONFIG_FILE_NAME = "edu.phoenixforce.scouting.mobile";
    private static final String KEY_DEVICE_ID = CONFIG_FILE_NAME + ".DeviceId";
    private static final String KEY_TBA_TEAM_ID = CONFIG_FILE_NAME + ".TbaTeamId";
    private static final String KEY_TBA_LAST_MODIFIED = CONFIG_FILE_NAME + ".TbaLastModified";

    //TextViews
    TextView autoBallHighA;
    TextView view1;
    TextView view2;
    TextView view3;
    TextView view4;

    CheckBox checkBox;


    //Buttons
    Button upButton1; //upButton in camel case
    Button upButton2;
    Button upButton3;
    Button upButton4;

    Button downButton1;
    Button downButton2;
    Button downButton3;
    Button downButton4;
    Button finishButton;
    //integers
    int counter1 = 0;
    int counter2 = 0;
    int counter3 = 0;
    int counter4 = 0;
    String counter5 = "0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_score);

        Constants constants = new Constants();


        //TextViews
        view1 = findViewById(R.id.integer_number1);
        view2 = findViewById(R.id.integer_number2);
        view3 = findViewById(R.id.integer_number3);
        view4 = findViewById(R.id.integer_number4);

        //Buttons
        upButton1 = findViewById(R.id.upbutton1);
        upButton2 = findViewById(R.id.upbutton2);
        upButton3 = findViewById(R.id.upbutton3);
        upButton4 = findViewById(R.id.upbutton4);

        downButton1 = findViewById(R.id.downbutton1);
        downButton2 = findViewById(R.id.downbutton2);
        downButton3 = findViewById(R.id.downbutton3);
        downButton4 = findViewById(R.id.downbutton4);

        finishButton = findViewById(R.id.finishedbutton);




        //on app launch Text View Must show zero

        view1.setText("0");
        view2.setText("0");
        view3.setText("0");
        view4.setText("0");

/*                backA.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        openMainActivity();

                    }
                });

 */


        upButton1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                counter1 = counter1 + 1;
                view1.setText(String.valueOf(counter1));
                constants.setAutoOne(counter1);
            }
        });

        checkBox = findViewById(R.id.moved);
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

        downButton1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (counter1 < 1){
                }
                else {
                    counter1 = counter1 - 1;
                    view1.setText(String.valueOf(counter1));
                    constants.setAutoOne(counter1);
                }


            }
        });

        //upbuttons
        upButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                counter2 = counter2 + 1;
                view2.setText(String.valueOf(counter2));
                constants.setAutoTwo(counter2);

            }

        });


        upButton3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                counter3 = counter3 + 1;
                view3.setText(String.valueOf(counter3));
                constants.setAutoThree(counter3);
            }

        });

        upButton4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                counter4 = counter4 + 1;
                view4.setText(String.valueOf(counter4));
                constants.setAutoFour(counter4);
            }

        });


        downButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (counter2 < 1){
                }
                else {
                    counter2 = counter2 - 1;
                    view2.setText(String.valueOf(counter2));
                    constants.setAutoTwo(counter2);
                }
            }

        });


        downButton3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (counter3 < 1){
                }
                else {
                    counter3 = counter3 - 1;
                    view3.setText(String.valueOf(counter3));
                    constants.setAutoThree(counter3);
                }
            }

        });

        downButton4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (counter4 < 1) {
                } else {

                    counter4 = counter4 - 1;
                    view4.setText(String.valueOf(counter4));
                    constants.setAutoFour(counter4);
                }
            }
        });

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

        editorTwo.putString("autoOne", String.valueOf(counter1));
        editorTwo.putString("autoTwo", String.valueOf(counter2));
        editorTwo.putString("autoThree", String.valueOf(counter3));
        editorTwo.putString("autoFour", String.valueOf(counter4));
        editorTwo.putString("autoMoved", counter5);

        editorTwo.apply();

        Log.d("auto", String.valueOf(counter5));
        Toast.makeText(this, "Finished auto-scouting", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, TeleScore.class);
        startActivity(intent);


    }


}
