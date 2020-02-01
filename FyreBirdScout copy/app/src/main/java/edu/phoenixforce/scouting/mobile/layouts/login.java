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

public class login extends AppCompatActivity {

    Spinner nombre;

    EditText pWord;

    Button log;

    String  user,pass, Lars, hello;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nombre = findViewById(R.id.name);
        pWord = findViewById(R.id.txtPassword);
        log = findViewById(R.id.btnSubmit);

        Lars = Lars;


        pass = pWord.getText().toString();

        String[] items = new String[]{"basic", "Lars", "Leo", "Jonathan", "Emily", "Aaron", "Erin"};
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
        String correct = "12345";

        if (user.equals("basic")) {


        } else {

            if (user.equals("Lars")){

                if (pass.equals("hello")){
                    goScout();

                }else{



                }



            }else{}



            //goScout();
        }


    }

    public void goScout() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }
}