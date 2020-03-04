package edu.phoenixforce.scouting.mobile.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.fyrebirdscout11.R;

import java.util.HashMap;

import edu.phoenixforce.scouting.mobile.database.The_other_ways_of_scoring.bainlactivity;
import edu.phoenixforce.scouting.mobile.database.The_other_ways_of_scoring.bainlactivity2;

public class login extends AppCompatActivity {

    Spinner nombre;

    EditText pWord;

    Button log, bypass, bypassII;

    String  pass, Lars, hello;

    public static String user;

    HashMap<String, String> users = new HashMap();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nombre = findViewById(R.id.name);
        pWord = findViewById(R.id.txtPassword);
        log = findViewById(R.id.btnSubmit);
        bypass = findViewById(R.id.bypass);
        bypassII = findViewById(R.id.bypassII);

        Lars = Lars;


        pass = pWord.getText().toString();

        String[] items = new String[]{"basic", "Lars", "Leo", "Jonathan", "Emily", "Aaron", "Erin", "Admin"}; //Hey andrew why is my name the second to last
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
        bypass.setOnClickListener(new View.OnClickListener() {

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
            users.put("Lars", "hello");
            users.put("Emily", "7902");
            users.put("Aaron", "2277766666");
            users.put("Admin", "nimda");


            if (user.equals("basic")) {

                goScout();

            } else {



                if (pass.equals(users.get(user))){
                    goScout();


                }else{




                }






            }







            //goScout();
        }


    public void goScout() {

        Intent intent = new Intent(this, ActivityMain.class);
        startActivity(intent);


    }


}
