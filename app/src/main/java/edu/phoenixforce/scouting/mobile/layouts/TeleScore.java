package edu.phoenixforce.scouting.mobile.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
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
    //TextViews
    TextView view1;
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

    public int differnce;
    public int parsedOldTime;


    public int moved = 0;
    public int spunwheel = 0; //default is zero, if the checkbox is clicked this number will be changed to onen can never be greater than one
    public int
            colorwheel = 0;
    public int balls = 0;
    public int solo = 0;
    public int buddy = 0;

//FOR ADDING THE AUTOSCORE STUFF

    //TextViews
    TextView autoBallHighA;
    TextView view7;
    TextView view8;
    TextView view9;
    TextView view10;


    //Buttons
    Button autoHighUp6; //upButton in camel case
    Button autoHighDown6; //downButton in camel case
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

    private static String scoutname;
    private static String teamnum;
    private static String match;
    String importedTeamNum;
    String importedMatchNum;
    String checkone;
    String checktwo;
    String checkthree;

    public void setImportedTeamNum(String importedTeamNum) {
        this.importedTeamNum = importedTeamNum;
    }

    public void setImportedMatchNum(String importedMatchNum) {
        this.importedMatchNum = importedMatchNum;
    }

    //integers
    public static int counter6 = 0;
    public static int counter7 = 0;
    public static int counter8 = 0;
    public static int counter9 = 0;
    public static int counter10 = 0;
    public static int X = 0;

    private static final String CONFIG_FILE_NAME = "edu.phoenixforce.scouting.mobile";
    private static final String KEY_DEVICE_ID = CONFIG_FILE_NAME + ".DeviceId";
    private static final String KEY_TBA_TEAM_ID = CONFIG_FILE_NAME + ".TbaTeamId";
    private static final String KEY_TBA_LAST_MODIFIED = CONFIG_FILE_NAME + ".TbaLastModified";


    public static int matchnumber;

    private static String tag = "TeleScore";

    public int timeTime;

    Timer clock = new Timer();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tele_score);
        Constants constants = new Constants();
        //RecyclerViewViewer.mWordViewModelII = new ViewModelProvider(this).get(TeleView.class);

        counter6 = 0;
        counter7 = 0;
        counter8 = 0;
        counter9 = 0;
        counter10 = 0;
        counter = 0;
        counter2 = 0;
        counter3 = 0;
        counter4 = 0;
        counter5 = 0;
        spunwheel = 0;
        colorwheel = 0;
        balls = 0;
        solo = 0;
        buddy = 0;

        timeTime = clock.currentTime;


        //TextViews

        view1 = findViewById(R.id.integer_number);
        view3 = findViewById(R.id.integer_number3);
        view2 = findViewById(R.id.integer_number2);
        view5 = findViewById(R.id.integer_number5);
        view4 = findViewById(R.id.integer_number4);

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

        //on app launch Text View Must show zero.setText("0");
        view1.setText("0");
        view3.setText("0");
        view2.setText("0");
        view4.setText("0");
        view5.setText("0");

        //AUTOSCORE STUFF


        autoBallHighA = findViewById(R.id.integer_number6);

        //Buttons
        autoHighUp6 = findViewById(R.id.upbutton6);
        autoHighDown6 = findViewById(R.id.downbutton6);

        // back = findViewById(R.id.imageButton);
        //navme = findViewById(R.id.navbutton);


        //timer =findViewById(R.id.timer);

        //on app launch Text View Must show zero
        autoBallHighA.setText("0");



        user = findViewById(R.id.show_user);

        SharedPreferences scorePrefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editorTwo = scorePrefs.edit();


        SharedPreferences myPrefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        scoutname = myPrefs.getString(TEXT, "No User");
        //dev = myPrefs.getString(devNUM, "Device Number Not Set");
        teamnum = myPrefs.getString(teamNum, "No Team Number");

        match = myPrefs.getString(matchNum, "No Match Number");

        matchnumber = Integer.valueOf(match);

        if(teamnum == "2097"){
            user.setText("Hi " + scoutname + " GO PHOENIX FORCE!");
        }
        else if(scoutname == "Admin"){
            user.setText("Keep up the hard work");
        }
        else if(scoutname == "Malia"){
            user.setText("Thanks for the help, Malia! Scouting team: " + teamnum);
        }
        else if(scoutname == "Syed"){
            user.setText("Thanks for the help, Syed! Scouting team: " + teamnum);
        }
        else if(scoutname.equals("Noam")){
            user.setText("Thanks for the help, Noam! Scouting team: " + teamnum);
        }
        else if(scoutname == "Gabriel"){
            user.setText("Thanks for the help, Gabriel! Scouting team:" + teamnum);
        }
        else if(scoutname == "Emily"){
            user.setText("Fergalicious definition scouting team: " + teamnum);
        }

        else {
            user.setText("Hi " + scoutname + ", Score Team " + teamnum + " During TeleOp Below!");
        }




     /*  backA.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View v) {
               openMainActivity();

           }
       });

      */

     /* Not sure why this one exists?
     timer.setOnClickListener(new View.OnClickListener(){
         @Override
         public void onClick(View v){

             writeTime();

         }

     }); */

        autoHighUp6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                counter6 = counter6 + 1;
                autoBallHighA.setText(String.valueOf(counter6));
                constants.setSix(counter6);


            }
        });

        autoHighDown6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               if (counter6 < 1){
               }
               else {
                   counter6 = counter6 - 1;
                   autoBallHighA.setText(String.valueOf(counter6));
                   constants.setSix(counter6);
               }
            }
        });


/*        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences timePrefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                String oldTime = timePrefs.getString("time", "0");




                SharedPreferences.Editor editorThree = timePrefs.edit();
                editorThree.putInt("time", timeTime);

            }
        });


       timer.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View v) {
              // openMainActivity();
               Log.d(tag,"This button is timer");
               Toast.makeText(TeleScore.this, "Saved your scores", Toast.LENGTH_LONG).show();
               TeleData teleData = new TeleData(String.valueOf(System.currentTimeMillis()), String.valueOf(TeleScore.counter2),
                       String.valueOf(TeleScore.counter3),String.valueOf(TeleScore.counter4),
                       String.valueOf(TeleScore.counter),String.valueOf(TeleScore.counter5),
                       spunwheel,colorwheel,balls,solo,buddy);
               //TODO this /\
               RecyclerViewViewer.mWordViewModelII.insert(teleData);
               //Log.d("Night Mode Update", teleData.toString());
               //Log.d("Night Mode Update", String.valueOf(team_select.show1));
               X = 1;

               AutoData autoData = new AutoData(String.valueOf(TeleScore.moved), String.valueOf(TeleScore.counter7), String.valueOf(TeleScore.counter8), String.valueOf(TeleScore.counter9), String.valueOf(TeleScore.counter6),
                       String.valueOf(TeleScore.counter10), String.valueOf(TeleScore.scoutname), String.valueOf(TeleScore.match), Integer.valueOf(TeleScore.matchnumber) );

               Toast.makeText(TeleScore.this, "Saved your scores", Toast.LENGTH_LONG).show();
               //-----------------------------------------------RIGHT HERE OFFICERS------------------------------------------------------------------------------------------------------------------------



           }
       });

*/

        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Log.d(tag, "this is back");

                openMainActivity();


            }


        });
        autoHighUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(counter <= 3) {
                    counter = counter + 1;
                    view1.setText(String.valueOf(counter));
                    constants.setOne(counter);
                }
                else{
                    Context context =getApplicationContext();
                    Toast toast = Toast.makeText(context, "Max Climb Level is 4 - Verify Climb Level", Toast.LENGTH_SHORT);
                    toast.show();

                }

            }
        });

        autoHighDown.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (counter < 1){
                }
                else {
                    counter = counter - 1;
                    view1.setText(String.valueOf(counter));
                    constants.setOne(counter);
                }
            }
        });

        //upbuttons
        upButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                counter2 = counter2 + 1;
                view2.setText(String.valueOf(counter2));
                constants.setTwo(counter2);

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
                    constants.setTwo(counter2);
                }

            }
        });
        upButton3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                counter3 = counter3 + 1;
                view3.setText(String.valueOf(counter3));
                constants.setThree(counter3);
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
                    constants.setThree(counter3);
                }
            }
        });
        upButton4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                    counter4 = counter4 + 1;

                    view4.setText(String.valueOf(counter4));
                    constants.setFour(counter4);

            }

        });
        downButton4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (counter4 < 1){
                }
                else {

                    counter4 = counter4 - 1;
                    view4.setText(String.valueOf(counter4));
                    constants.setFour(counter4);
                }

            }
        });
        upButton5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                counter5 = counter5 + 1;
                view5.setText(String.valueOf(counter5));
                constants.setFive(counter5);

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
                    constants.setThree(counter3);
                }
            }
        });
      /*  downButton4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick (View v){

            counter4 = counter4 - 1;
            view4.setText(String.valueOf(counter4));
            constants.setFour(counter4);

        }
        });
        upButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){

                counter4 = counter4 + 1;
                view4.setText(String.valueOf(counter4));
                constants.setFour(counter4);
            }
            });
        */

                downButton5.setOnClickListener(new View.OnClickListener (){

            @Override
            public void onClick(View v) {
                if (counter5< 1){
                }
                else {

                    counter5 = counter5 - 1;
                    view5.setText(String.valueOf(counter5));
                    constants.setFive(counter5);
                }
            }


        });
    }








    public void onCheckboxClicked(View view) { //this is for all of the checkboxes in the activity
        //Log.d("hola",String.valueOf(colorwheel));
        boolean checked = ((CheckBox) view).isChecked();
        //Log.d("hola",String.valueOf(colorwheel));
        //check for what checkbox is checked
        switch (view.getId()) {


            case R.id.checkOne: {
                if (checked) {
                    checkone = "1";
                } else {
                    checkone = "0";
                }
                break;
            }

            case R.id.check2: {
                if (checked) {

                    checktwo = "1";
                } else {

                    checktwo = "0";
                }
                break;
            }

            case R.id.check3: {
                if (checked) {
                    checkthree = "1";

                } else {
                    checkthree = "0";

                }
                break;
            }
        }
    }

        public void openMainActivity() {

            Constants constantsone = new Constants();

            constantsone.setEleven(solo);
            constantsone.setTwelve(buddy);
            constantsone.setThirteen(spunwheel);
            constantsone.setFourteen(colorwheel);
            constantsone.setFifteen(balls);
            constantsone.setSixteen(moved);

            //constantsone.setData(this);
            saveGameData();

            Log.d("Testing", "openMainRan");
            Intent intent = new Intent(this, ActivityMain.class);
            startActivity(intent);

            //  saveGameData();

            Toast.makeText(TeleScore.this, "Saved your scores", Toast.LENGTH_LONG).show();

            //TODO this /


            Log.d("Night Mode Update", String.valueOf(team_select.show1));
            X = 1;


        }



        public void saveGameData() {

        Constants constants = new Constants();

        constants.getPrefs(this);
      ScoreDataBase SDB = ScoreDataBase.getDatabase(this);

      //  GameData gameData = new GameData(constants.getUser(),"2","3","4", "5", "6", "7", "8", "9"
       //        , "10", "11", "12", "13", "14", "15", "16");

            SharedPreferences scorePrefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

            String autoCounter1 = scorePrefs.getString("autoOne", "0");
            String autoCounter2 = scorePrefs.getString("autoTwo", "0");
            String autoCounter3 = scorePrefs.getString("autoThree", "0");
            String autoCounter4 = scorePrefs.getString("autoFour", "0");
            String autoCounter5 = scorePrefs.getString("autoMoved", "0");


            GameData gameData = new GameData(scoutname, String.valueOf(constants.getDeviceId()), match, teamnum,
                    autoCounter5, checkone, String.valueOf(counter), String.valueOf(counter2),
                    String.valueOf(counter3), autoCounter1, autoCounter2, autoCounter3, autoCounter4,
                    String.valueOf(counter4), String.valueOf(counter5), String.valueOf(counter6),checktwo, checkthree);





      /*      Log.d("tele", text + constants.getDeviceId() +  match + teamnum +
                    constants.getAutoThree() + constants.getTwelve() + constants.getOne() + constants.getTwo() +
                constants.getThree() + constants.getAutoOne() + constants.getAutoTwo() +
                    constants.getFour() + constants.getFive() + constants.getSix()  + constants.getEleven() +
                    constants.getThirteen());


       */

            Log.d("counter5", autoCounter5);
        SDB.gameDao().insertAll(gameData);




        //this is a new comment, this better work!


    }




        }









