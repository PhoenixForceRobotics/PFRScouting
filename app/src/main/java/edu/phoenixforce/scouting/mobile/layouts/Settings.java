package edu.phoenixforce.scouting.mobile.layouts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


import com.example.fyrebirdscout11.R;

import static java.sql.DriverManager.println;

public class Settings extends AppCompatActivity {

    private final int time = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


    }



    public void night_mode(View view) throws InterruptedException {

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        startActivity(new Intent(getApplicationContext(), ActivityMain.class));
        finish();
        Log.d("Night mode update", "Night Mode is currently off");
        println("Night Mode is currently off");
        Thread.sleep(time);
    }

    public void Light_Mode(View view) throws InterruptedException {

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        startActivity(new Intent(getApplicationContext(), ActivityMain.class));
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
