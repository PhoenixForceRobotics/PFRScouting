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


public class AutoScore extends AppCompatActivity {


    //TextViews
            TextView autoBallHighA;
            TextView view7;
            TextView view8;
            TextView view9;
            TextView view10;


            //Buttons
            Button autoHighUpA; //upButton in camel case
            Button autoHighDownB; //downButton in camel case
            Button upButton7;
            Button upButton8;
            Button upButton9;
            Button upButton10;
            Button downButton7;
            Button downButton8;
            Button downButton9;
            Button downButton10;
            ImageButton backA;
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
                autoBallHighA = findViewById(R.id.integer_number);
                view7 = findViewById(R.id.integer_number2);
                view8 = findViewById(R.id.integer_number3);
                view9 = findViewById(R.id.integer_number4);
                view10 = findViewById(R.id.integer_number5);

                //Buttons
                autoHighUpA = findViewById(R.id.upbutton6);
                autoHighDownB = findViewById(R.id.downbutton);

               // back = findViewById(R.id.imageButton);
                //navme = findViewById(R.id.navbutton);

                upButton7 = findViewById(R.id.upbutton7);
                upButton8 = findViewById(R.id.upbutton8);
                upButton9 = findViewById(R.id.upbutton9);
                upButton10 = findViewById(R.id.upbutton10);

                downButton7 = findViewById(R.id.downbutton7);
                downButton8 = findViewById(R.id.downbutton8);
                downButton9 = findViewById(R.id.downbutton9);
                downButton10 = findViewById(R.id.downbutton10);

                //on app launch Text View Must show zero
                autoBallHighA.setText("0");
                view7.setText("0");
                view8.setText("0");
                view9.setText("0");
                view10.setText("0");

                backA.setOnClickListener(new View.OnClickListener() {

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
                autoHighUpA.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        counter6 = counter6 + 1;
                        autoBallHighA.setText(String.valueOf(counter6));
                    }
                });

                autoHighDownB.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        counter6 = counter6 - 1;
                        autoBallHighA.setText(String.valueOf(counter6));
                    }
                });

                //upbuttons
                upButton7.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        counter7 = counter7 + 1;
                        view7.setText(String.valueOf(counter7));
                    }
                });

                upButton8.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {

                        counter8 = counter8 + 1;
                        view8.setText (String.valueOf(counter8));
                    }

                });

                upButton9.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {

                        counter9 = counter9 + 1;
                        view9.setText (String.valueOf(counter9));
                    }

                });

                upButton10.setOnClickListener(new View.OnClickListener (){

                    @Override
                    public void onClick(View v) {

                        counter10 = counter10 + 1;
                        view10.setText (String.valueOf(counter10));
                    }

                });

                downButton7.setOnClickListener(new View.OnClickListener (){

                    @Override
                    public void onClick(View v) {

                        counter7 = counter7 - 1;
                        view7.setText(String.valueOf(counter7));

                    }
                });

                downButton8.setOnClickListener(new View.OnClickListener (){

                    @Override
                    public void onClick(View v) {

                        counter8 = counter8 - 1;
                        view8.setText(String.valueOf(counter8));
                    }
                });

                downButton9.setOnClickListener(new View.OnClickListener (){

                    @Override
                    public void onClick(View v) {

                        counter9 = counter9 - 1;
                        view9.setText(String.valueOf(counter9));

                    }
                });

                downButton10.setOnClickListener(new View.OnClickListener (){

                    @Override
                    public void onClick(View v) {

                        counter10 = counter10 - 1;
                        view10.setText (String.valueOf(counter10));
                    }


                });
            }
            public void openMainActivity(){

                Intent intent = new Intent(this, ActivityMain.class);
                startActivity(intent);

            }
            public void goTeleScore(){

                Intent intent = new Intent(this, TeleScore.class);
                startActivity(intent);



            }



}










