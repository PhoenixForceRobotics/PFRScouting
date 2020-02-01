package edu.phoenixforce.scouting.mobile.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//import android.widget.CheckBox; -- Not needed during the auto period
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.fyrebirdscout11.R;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AutoScore extends AppCompatActivity {


    //TextViews
            TextView autoBallHigh;
            TextView view2;
            TextView view3;
            TextView view4;
            TextView view5;


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
            ImageButton back;
            Button navme;

            //integers
            int counter6 = 0;
            int counter7 = 0;
            int counter8 = 0;
            int counter9 = 0;
            int counter10 = 0;





            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_auto_score);

                //TextViews
                autoBallHigh = findViewById(R.id.integer_number);
                view2 = findViewById(R.id.integer_number2);
                view3 = findViewById(R.id.integer_number3);
                view4 = findViewById(R.id.integer_number4);
                view5 = findViewById(R.id.integer_number5);

                //Buttons
                autoHighUp = findViewById(R.id.upbutton);
                autoHighDown = findViewById(R.id.downbutton);

                back = findViewById(R.id.imageButton);
                navme = findViewById(R.id.navbutton);

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

                navme.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        goTeleScore();
                    }

                });
                autoHighUp.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        counter6 = counter6 + 1;
                        autoBallHigh.setText(String.valueOf(counter6));
                    }
                });

                autoHighDown.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        counter6 = counter6 - 1;
                        autoBallHigh.setText(String.valueOf(counter6));
                    }
                });

                //upbuttons
                upButton2.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        counter7 = counter7 + 1;
                        view2.setText(String.valueOf(counter7));
                    }
                });

                upButton3.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {

                        counter8 = counter8 + 1;
                        view3.setText (String.valueOf(counter8));
                    }

                });

                upButton4.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {

                        counter9 = counter9 + 1;
                        view4.setText (String.valueOf(counter9));
                    }

                });

                upButton5.setOnClickListener(new View.OnClickListener (){

                    @Override
                    public void onClick(View v) {

                        counter10 = counter10 + 1;
                        view5.setText (String.valueOf(counter10));
                    }

                });

                downButton2.setOnClickListener(new View.OnClickListener (){

                    @Override
                    public void onClick(View v) {

                        counter7 = counter7 - 1;
                        view2.setText(String.valueOf(counter7));

                    }
                });

                downButton3.setOnClickListener(new View.OnClickListener (){

                    @Override
                    public void onClick(View v) {

                        counter8 = counter8 - 1;
                        view3.setText(String.valueOf(counter8));
                    }
                });

                downButton4.setOnClickListener(new View.OnClickListener (){

                    @Override
                    public void onClick(View v) {

                        counter9 = counter9 - 1;
                        view4.setText(String.valueOf(counter9));

                    }
                });

                downButton5.setOnClickListener(new View.OnClickListener (){

                    @Override
                    public void onClick(View v) {

                        counter10 = counter10 - 1;
                        view5.setText (String.valueOf(counter10));
                    }


                });
            }
            public void openMainActivity(){

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);

            }
            public void goTeleScore(){

                Intent intent = new Intent(this, TeleScore.class);
                startActivity(intent);



            }



}










