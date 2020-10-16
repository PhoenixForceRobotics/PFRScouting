package edu.phoenixforce.scouting.mobile.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.fyrebirdscout11.R;

import java.util.HashMap;


public class login extends AppCompatActivity {

    Spinner nombre;

    EditText pWord;

    Button log;

    String  pass;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "user";

    public static String text;

    public static String user;

    HashMap<String, String> users = new HashMap();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        loadData();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nombre = findViewById(R.id.name);
        pWord = findViewById(R.id.txtPassword);
        log = findViewById(R.id.btnSubmit);
        //bypass = findViewById(R.id.bypass);
        //bypassII = findViewById(R.id.bypassII);




        pass = pWord.getText().toString();

        String[] items = new String[]{"Select User", "Andrew", "Admin", "Cap", "Leo",
        "Guthrie", "Emily", "Jonathan", "Edward", "Harpreet", "Christian", "Katie", "Alexander", "Luci"}; //Hey andrew why is my name the second to last
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        nombre.setAdapter(adapter);

        log.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                validateUser();


            }


        });
       /* bypass.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                goScout();

            }


        });
        bypass.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                goScout();

            }


        });
        bypassII.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                goScout();

            }


        });


        */

    }



    /*public void validateUser(){

        if (nombre.equals("Lars")){

            if(pWord.equals("hello")){
            goScout();
            }else{



            }


        }else{


        }


    }*/ //Something that I was playing with

    public void validateUser() {



            user = nombre.getSelectedItem().toString();
            pass = pWord.getText().toString();


            //Create the users in the HashMap;

            users.put("Emily", "1116");
            users.put("Aaron", "1112");
            users.put("Admin", "nimda");
            users.put("Andrew", "1111");
            users.put("Cap", "1113");
            users.put("Leo", "1114");
            users.put("Guthrie", "1115");
            users.put("Jonathan", "1117");
            users.put("Edward", "1118");
            users.put("Susan", "1119");
            users.put("Harpreet", "1110");
            users.put("Christian", "1120");
            users.put("Katie", "1121");
            users.put("Bert", "1122");
            users.put("Alexander", "1123");
            users.put("Luci", "1124");

            if (user.equals("Select User")) {



            } else {



                if (pass.equals(users.get(user))){
                    saveUser();


                }else{




                }






            }







            //goScout();
        }

        public void saveUser(){

SharedPreferences myPrefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
SharedPreferences.Editor editor = myPrefs.edit();

editor.putString(TEXT, user);

editor.apply();

Toast.makeText(this, "Logged In as" + user, Toast.LENGTH_SHORT).show();

goScout();
        }
    public void goScout() {

        Intent intent = new Intent(this, team_select.class);
        startActivity(intent);


    }

    public void loadData(){



        SharedPreferences myPrefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = myPrefs.getString(TEXT, "");



    }




}
