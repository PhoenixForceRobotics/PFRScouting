package edu.phoenixforce.scouting.mobile.layouts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Button;


import com.example.fyrebirdscout11.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static android.provider.Telephony.Mms.Part.FILENAME;
import static java.sql.DriverManager.println;

public class Settings extends AppCompatActivity {

    private int time = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

      /*  deviceId = findViewById(R.id.deviceid);
        saver = findViewById(R.id.save);
        pWord = findViewById(R.id.password);*/

        //int correct;

        //String answer = pWord.getText().toString();


        // int password = Integer.parseInt(answer);

        //correct = 2294;

        /*saver.setOnClickListener(new View.OnClickListener(){

            @Override public void onClick(View v) {
                writeFile();

            }
        });*/

    }

    public void night_mode(View view) throws InterruptedException {

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
        Log.d("Night mode update", "Night Mode is currently off");
        println("Night Mode is currently off");
        Thread.sleep(time);
    }

    public void Light_Mode(View view) throws InterruptedException {

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
        Log.d("Night mode update", "Night Mode is currently on");
        println("Night Mode is currently on");
        Thread.sleep(time);
    }

   /* private void writeFile() {
        String deviceNumber = deviceId.getText().toString();
        try {
           FileOutputStream fileOutputStream = openFileOutput("DeviceNum.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(deviceNumber.getBytes());
            fileOutputStream.close();

            Toast.makeText(getApplicationContext(), "text saved", Toast.LENGTH_SHORT).show();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    private void readFile() {

        try {
            FileInputStream fileInputStream = openFileInput("DeviceNum.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            String lines;
            while ((lines = bufferedReader.readLine()) != null) {
                stringBuffer.append(lines + "\n");

            }


            //displayText.setText(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();


        }
    }*/}
