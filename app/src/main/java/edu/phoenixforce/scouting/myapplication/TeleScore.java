package edu.phoenixforce.scouting.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class TeleScore extends AppCompatActivity {
//TextViews
TextView autoBallHigh;
TextView view2;
TextView view3;
TextView view4;
TextView view5;

//edit text for the team number
//EditText teamNumber = (EditText) findViewById(R.id.team_number);
//String Numero = teamNumber.getText().toString();
//int numberTeam = Integer.parseInt(Numero);


//Buttons
Button autoHighUp; //upButton in camel case
Button autoHighDown; //downButton in camel case
Button upButton2;
Button upButton3;
Button upButton4;
Button upButton5;
Button downButton2;
Button downButton3;
Button downButton4;
Button downButton5;
Button back;

//integers
int counter = 0;
int counter2 = 0;
int counter3 = 0;
int counter4 = 0;
int counter5 = 0;
int spunwheel = 0; //default is zero, if the checkbox is clicked this number will be changed to onen can never be greater than one
int colorwheel = 0;
int solo = 0;
int buddy = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tele_score);

        //TextViews
        autoBallHigh = findViewById(R.id.integer_number);
        view2 = findViewById(R.id.integer_number2);
        view3 = findViewById(R.id.integer_number3);
        view4 = findViewById(R.id.integer_number4);
        view5 = findViewById(R.id.integer_number5);

        //Buttons
        autoHighUp = findViewById(R.id.upbutton);
        autoHighDown = findViewById(R.id.downbutton);

        back = findViewById(R.id.donebutton);

        upButton2 = findViewById(R.id.upbutton2);
        upButton3 = findViewById(R.id.upbutton3);
        upButton4 = findViewById(R.id.upbutton4);
        upButton5 = findViewById(R.id.upbutton5);

        downButton2 = findViewById(R.id.downbutton2);
        downButton3 = findViewById(R.id.downbutton3);
        downButton4 = findViewById(R.id.downbutton4);
        downButton5 = findViewById(R.id.downbutton5);

        //on app launch Text View Must show zero
        autoBallHigh.setText("0");
        view2.setText("0");
        view3.setText("0");
        view4.setText("0");
        view5.setText("0");



        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openMainActivity();

            }
        });
        autoHighUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                counter = counter + 1;
                autoBallHigh.setText(String.valueOf(counter));
            }
        });

        autoHighDown.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                counter = counter - 1;
                autoBallHigh.setText(String.valueOf(counter));
            }
        });

        //upbuttons
        upButton2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                counter2 = counter2 + 1;
                view2.setText(String.valueOf(counter2));
            }
        });

        upButton3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                counter3 = counter3 + 1;
                view3.setText (String.valueOf(counter3));
            }

        });

        upButton4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                counter4 = counter4 + 1;
                view4.setText (String.valueOf(counter4));
            }

        });

        upButton5.setOnClickListener(new View.OnClickListener (){

            @Override
            public void onClick(View v) {

                counter5 = counter5 + 1;
                view5.setText (String.valueOf(counter5));
            }

        });

        downButton2.setOnClickListener(new View.OnClickListener (){

            @Override
            public void onClick(View v) {

                counter2 = counter2 - 1;
                view2.setText(String.valueOf(counter2));

            }
        });

        downButton3.setOnClickListener(new View.OnClickListener (){

            @Override
            public void onClick(View v) {

                counter3 = counter3 - 1;
                view3.setText(String.valueOf(counter3));
            }
        });

        downButton4.setOnClickListener(new View.OnClickListener (){

           @Override
           public void onClick(View v) {

               counter4 = counter4 - 1;
               view4.setText(String.valueOf(counter4));

           }
        });

        downButton5.setOnClickListener(new View.OnClickListener (){

            @Override
            public void onClick(View v) {

                counter5 = counter5 - 1;
                view5.setText (String.valueOf(counter5));
            }


        });
    }

    public void onCheckboxClicked(View view) { //this is for all of the checkboxes in the activity

        boolean checked = ((CheckBox) view).isChecked();

        //check for what checkbox is checked
        switch(view.getId()){
            case R.id.checkBox1:
                if (checked)
                    solo = solo + 1;
                else
                    solo = 0;
                break;

            case R.id.checkBox2:
                if (checked)
                    buddy = buddy + 1;
                else
                    buddy = 0;
                break;

            case R.id.checkBox3:
                if(checked)
                    spunwheel = spunwheel + 1;
                else
                    spunwheel = 0;
                break;

            case R.id.checkBox4:
                if(checked)
                    colorwheel = colorwheel + 1;
                else
                    colorwheel = 0;
                break;

        }

    }
    public void openMainActivity(){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}

