package edu.phoenixforce.scouting.mobile.layouts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.fyrebirdscout11.R;

import java.util.Calendar;

import edu.phoenixforce.scouting.mobile.database.ViewModels.TeleView;
import edu.phoenixforce.scouting.mobile.database.entities.TeleData;
import edu.phoenixforce.scouting.mobile.database.recyclervewveiwers.RecyclerViewViewer;

import static edu.phoenixforce.scouting.mobile.layouts.login.SHARED_PREFS;
import static edu.phoenixforce.scouting.mobile.layouts.login.TEXT;
import static edu.phoenixforce.scouting.mobile.layouts.team_select.matchNum;
import static edu.phoenixforce.scouting.mobile.layouts.team_select.teamNum;

public class TeleScore extends AppCompatActivity {
//TextViews
TextView autoBallHigh;
TextView view2;
TextView view3;
TextView view4;
TextView view5;
TextView user;

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
Button timer;

//integers
public static int counter = 0;
    public static int counter2 = 0;
    public static int counter3 = 0;
    public static int counter4 = 0;
    public static int counter5 = 0;
    public static int spunwheel = 0; //default is zero, if the checkbox is clicked this number will be changed to onen can never be greater than one
    public static int colorwheel = 1;
    public static int balls = 0;
    public static int solo = 0;
    public static int buddy = 0;

//FOR ADDING THE AUTOSCORE STUFF

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
   // ImageButton backA;
    Button navme;

    String scoutname;
    String teamnum;
    String match;

    //integers
    public static int counter6 = 0;
    public static int counter7 = 0;
    public static int counter8 = 0;
    public static int counter9 = 0;
    public static int counter10 = 0;
    public static int X = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tele_score);
        RecyclerViewViewer.mWordViewModelII = new ViewModelProvider(this).get(TeleView.class);



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

        //AUTOSCORE STUFF

        view7 = findViewById(R.id.integer_number7);
        view8 = findViewById(R.id.integer_number8);
        view9 = findViewById(R.id.integer_number9);
        view10 = findViewById(R.id.integer_number10);
        autoBallHighA = findViewById(R.id.integer_number6);

        //Buttons
        autoHighUpA = findViewById(R.id.upbutton6);
        autoHighDownB = findViewById(R.id.downbutton6);

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

        timer =findViewById(R.id.timer);

        //on app launch Text View Must show zero
        autoBallHighA.setText("0");
        view7.setText("0");
        view8.setText("0");
        view9.setText("0");
        view10.setText("0");



        SharedPreferences myPrefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        scoutname = myPrefs.getString(TEXT, "No User");
        //dev = myPrefs.getString(dEVNUM, "Device Number Not Set");
        teamnum = myPrefs.getString(teamNum, "No Team Number");

        match = myPrefs.getString(matchNum, "No Match Number");


        user.setText(scoutname +  " Team " + teamnum + " Match " + match);





      /*  backA.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openMainActivity();

            }
        });

       */

      timer.setOnClickListener(new View.OnClickListener(){
          @Override
          public void onClick(View v){

              writeTime();

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


        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openMainActivity();
                Toast.makeText(TeleScore.this, "Saved your scores", Toast.LENGTH_LONG).show();
                TeleData teleData = new TeleData(String.valueOf(TeleScore.counter2),String.valueOf(TeleScore.counter3),String.valueOf(TeleScore.counter4),
                        String.valueOf(TeleScore.spunwheel),String.valueOf(TeleScore.colorwheel),String.valueOf(TeleScore.balls),
                        String.valueOf(TeleScore.solo),String.valueOf(TeleScore.buddy),String.valueOf(TeleScore.counter),String.valueOf(TeleScore.counter5));
                //TODO this /\
                RecyclerViewViewer.mWordViewModelII.insert(teleData);
                Log.d("Night Mode Update", teleData.toString());
                X = 1;

                //-----------------------------------------------RIGHT HERE OFFICERS------------------------------------------------------------------------------------------------------------------------

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
        Log.d("hola",String.valueOf(colorwheel));
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

            case R.id.checkBox:
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


            case R.id.checkBox3:
                if(checked)
                    balls = balls + 1;
                else
                    balls = 0;
                break;

        }

    }
    public void openMainActivity(){

        Intent intent = new Intent(this, ActivityMain.class);
        startActivity(intent);

    }

    public void goScoutIII() {

        Intent intent = new Intent(this, RecyclerViewViewer.class);
        startActivity(intent);

    }

           public void writeTime(){

               //creating Calendar instance
               Calendar calendar = Calendar.getInstance();
               //Returns current time in millis
               long timeMilli2 = calendar.getTimeInMillis();
               System.out.println("Time in milliseconds using Calendar: " + timeMilli2);

    }
}

