package edu.phoenixforce.scouting.mobile.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
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
    int easter = 1;

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
        pWord.setVisibility(View.INVISIBLE);

        pass = pWord.getText().toString();

        String name;

        String[] items = new String[]{"Select User", "Admin",  "PitUser", "QRScanner", "Alejandra", "Alem", "Alex",
                "Allia", "Amanuel", "Andrew", "Anan", "Arian", "Bryce", "Cecelia", "Chloe", "Conor", "Elena", "Eleanor",
                "Ethan", "Francesca","Gabriel", "Gerardo", "Jenny", "Jordan", "Josue", "Kameron", "Katie", "Lauren", "Leon",
                "Malia", "Maria", "Maxwell", "Nate", "Noam", "Quang-Hy", "Raf", "Shou", "Syed", "Victor", "Vish"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        nombre.setAdapter(adapter);

        nombre.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l){
                String result = nombre.getSelectedItem().toString();
                if (result == "Select User" || result == "Admin" || result == "PitUser" || result == "QRScanner"){

                    pWord.setVisibility(View.VISIBLE);

                }
                else{
                    pWord.setVisibility(View.INVISIBLE);
                }




            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView){

            }

        });
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

            users.put("Admin", "6969"); users.put("PitUser", "1983"); users.put("QRScanner", "1984");users.put("Andrew", "1111");
            users.put("Alejandra", "1112"); users.put("Alem", "1113"); users.put("Alex", "1114");users.put("Allia", "1116");
            users.put("Amanuel", "1115"); users.put("Anan", "1117"); users.put("Arian", "1118");users.put("Bryce", "1119");
            users.put("Cecelia", "1120");users.put("Chloe", "1121"); users.put("Conor", "1122"); users.put("Elena", "1123");
            users.put("Eleanor", "1124");users.put("Ethan", "1125"); users.put("Francesca", "1126");users.put("Gabriel", "1127");
            users.put("Jenny", "1128"); users.put("Jordan", "1129"); users.put("Josue", "1130"); users.put("Kameron", "1131");
            users.put("Katie", "1132");users.put("Lauren", "1133"); users.put("Leon", "1134");
            users.put("Malia", "1135"); users.put("Maria", "1136"); users.put("Maxwell", "1137");users.put("Nate", "1138"); users.put("Noam", "1139");
            users.put("Quang-Hy", "1140"); users.put("Raf", "1141"); users.put("Shou", "1142"); users.put("Syed", "1143");users.put("Victor", "1144");
            users.put("Vish", "1145");

            if (user.equals("Select User")) {



            } else {



                if (pass.equals(users.get(user)) && (user.equals("Admin") || user.equals("PitUser"))){

                    
                    saveUser(0);



                }
                else if(pass.equals("1984") && user == "QRScanner"){
                    saveUser(3);
                }
                else if(pass.equals("0000")){
                    saveUser(1);
                }
                else if((user.equals("Admin") || user.equals("PitUser")) && !pass.equals(users.get(user))){
                    Toast.makeText(login.this, "This User Requires Admin Key!", Toast.LENGTH_LONG).show();
                }
                else if (user.equals("QRScanner")){

                    Toast.makeText(login.this, "This User Requires Password Key!", Toast.LENGTH_LONG).show();
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

        if (easter < 5) {
            Toast.makeText(this, "You Cannot Return to the Previous Page", Toast.LENGTH_LONG).show();
            easter++;
        }
        else if (easter == 5){
            Toast.makeText(this, "You really need to take a break", Toast.LENGTH_LONG).show();
            easter ++;
        }
        else if (easter > 5 && easter < 10){
            Toast.makeText(this, "You Cannot Return to the Previous Page", Toast.LENGTH_LONG).show();
            easter ++;
        }
        else{
            Toast.makeText(this, "You really are persistant", Toast.LENGTH_LONG).show();
            easter = 0;
        }

    }




}
