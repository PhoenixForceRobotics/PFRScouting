package edu.phoenixforce.scouting.mobile.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.fyrebirdscout11.R;
import edu.phoenixforce.scouting.*;
import edu.phoenixforce.scouting.mobile.common.Constants;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Locale;


public class login extends AppCompatActivity {

    Spinner nombre;

    EditText pWord;

    Button log;

    String  pass;

    //String snoqualmie;

    int New = 2;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "user";

    public static String text;

    public static String user;

    HashMap<String, String> users = new HashMap();
    Constants constants = new Constants();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       Constants constants = new Constants();
       Context context = this;


       //constants.setVal();

       //constants.createVal(New);





        loadData();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nombre = findViewById(R.id.name);
        pWord = findViewById(R.id.txtPassword);
        log = findViewById(R.id.btnSubmit);
        //bypass = findViewById(R.id.bypass);
        //bypassII = findViewById(R.id.bypassII);


        pass = pWord.getText().toString();

        String name;

        String[] items = new String[]{"Select User", "Admin", "Andrew", "Gabriel", "Andy", "Alem", "Syed"
                , "Lauren A", "Kheana", "Shou", "Vish", "Elsdon", "J", "Christian", "Katie", "Nova", "Ethan", "Cameron",
                "Nicky", "Katelyn", "Edward", "Hudson", "Mustaf", "Leon Alfonso", "Maddi", "Chloe", "Alex notProgramming", "Ryan", "Eleanor"
                , "Dalen", "John", "Ryan", "Elena", "Jonathan", "Anan", "Jordan", "Saturn", "Oskar", "Maria", "Maxwell",
                "Colm", "Esther", "Francesca", "Seven", "Lauren's Brother", "Cap's Sister", "Raf", "Lars", "Sarah", "Trent", "Regan", "Taylor", "Allia"
                , "Kameron", "Victor", "Alex Programming", "Conner", "Lincoln", "Alejandra", "Harpreet", "Jacob", "Noam", "Guthrie", "Jenny",
                "Caleb", "Eileen", "Nathaniel", "Malia", "Emily", "Brandon", "Seiji", "Josue", "Elijah",  "PitUser"};
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

    public void validateUser() {
        Log.d("login", "saveuser ran");
            user = nombre.getSelectedItem().toString();
            pass = pWord.getText().toString();

            //Create the users in the HashMap!

            users.put("Admin", "6969"); users.put("Andrew", "1111"); users.put("Gabriel", "1112"); users.put("Andy", "1113"); users.put("Alem", "1114");
            users.put("Syed", "1116"); users.put("Lauren A", "1115"); users.put("Kheana", "1117"); users.put("Shou", "1118");users.put("Vish", "1119");
            users.put("Elsdon", "1120");users.put("J", "1121"); users.put("Christian", "1122"); users.put("Katie", "1123"); users.put("Nova", "1124");
            users.put("Ethan", "1125"); users.put("Cameron", "1126");users.put("Nicky", "1127"); users.put("Katelyn", "1128"); users.put("Edward", "1129");
            users.put("Hudson", "1130"); users.put("Mustaf", "1131"); users.put("Leon Alfonso", "1132");users.put("Maddi", "1133"); users.put("Chloe", "1134");
            users.put("Alex notProgramming", "1135"); users.put("Rya n", "1136"); users.put("Eleanor", "1137");users.put("Dalen", "1138"); users.put("John", "1139");
            users.put("Elena", "1140"); users.put("Jonathan", "1141"); users.put("Anan", "1142"); users.put("Jordan", "1143");users.put("Saturn", "1144");
            users.put("Oskar", "1145"); users.put("Maria", "1146"); users.put("Maxwell", "1147"); users.put("Colm", "1148"); users.put("Esther", "1149");
            users.put("Francesca", "1150"); users.put("Seven", "1151"); users.put("Lauren's Brother", "1152"); users.put("Cap's Sister", "1153"); users.put("Raf", "1154");
            users.put("Lars", "1155");users.put("Sarah", "1156"); users.put("Trent", "1157"); users.put("Regan", "1158"); users.put("Taylor", "1159");
            users.put("Allia", "1160"); users.put("Kameron", "1161");users.put("Victor", "1163"); users.put("Alex Programming", "1164"); users.put("Conner", "1165");
            users.put("Lincoln", "1166"); users.put("Alejandra", "1167"); users.put("Harpreet","1168");users.put("Jacob", "1169"); users.put("Noam", "2269");
            users.put("Guthrie", "1170"); users.put("Jenny", "1171"); users.put("Caleb","1172"); users.put("Eileen", "1173"); users.put("Malia", "1174");users.put("Emily", "1175");
            users.put("Brandon", "1176"); users.put("PitUser", "1983");

            if (user.equals("Select User")) {



            } else {



                if (pass.equals(users.get(user)) && (user.equals("Admin") || user.equals("PitUser"))){

                    
                    saveUser(0);



                }
                else if(pass.equals("0000")){
                    saveUser(1);
                }
                else if((user.equals("Admin") || user.equals("PitUser")) && !pass.equals(users.get(user))){
                    Toast.makeText(login.this, "This User Requires Admin Key!", Toast.LENGTH_LONG).show();
                }
                else{
                    saveUser(0);
                    Toast.makeText(login.this, "Signed in", Toast.LENGTH_LONG).show();
                }






            }







            //goScout();
        }

        public void saveUser(int i){

        Log.d("login", "saveuser ran");
SharedPreferences myPrefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
SharedPreferences.Editor editor = myPrefs.edit();

editor.putString(TEXT, user);
editor.putInt("state", i);

Constants constants = new Constants();
constants.setUser(user);
editor.apply();

Toast.makeText(this, "Logged In as" + user, Toast.LENGTH_SHORT).show();

goScout();
//constants.setUser(user);
        }
    public void goScout() {
        Log.d("login", "saveuser ran");

        Intent intent = new Intent(this, ActivityMain.class);
        startActivity(intent);


    }

    public void loadData(){
        Log.d("login", "saveuser ran");



        SharedPreferences myPrefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = myPrefs.getString(TEXT, "");



    }

    @Override
    public void onBackPressed(){

        Toast.makeText(this, "You Cannot Return to the Previous Page", Toast.LENGTH_LONG).show();

    }



}
