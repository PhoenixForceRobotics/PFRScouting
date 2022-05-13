package edu.phoenixforce.scouting.mobile.layouts;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.fyrebirdscout11.R;

import java.io.ByteArrayOutputStream;

import edu.phoenixforce.scouting.mobile.common.Constants;
import edu.phoenixforce.scouting.mobile.database.ScoreDataBase;
import edu.phoenixforce.scouting.mobile.database.entities.PitData;

public class ActivityPitScout extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {
    String robotInfo;
    String userThoughts;
    String projectedCycleTime;
    String projectedClimbLevel;
    String teamNum;
    EditText robotInfoBox;
    EditText userThoughtsBox;
    EditText projectedCycleTimeBox;
    EditText projectedClimbLevelBox;
    EditText teamNumBox;
    Button Finished;
    Button Activate_Camera;
    ImageView imageView;
    int count7 = 0;

    byte[] byteArray;
    static final int RIC = 1;

    Constants constants = new Constants();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pitscout);
        imageView = findViewById(R.id.imageView6);

        robotInfoBox = findViewById(R.id.textView9);
        userThoughtsBox = findViewById(R.id.textView18);
        projectedCycleTimeBox = findViewById(R.id.textView21);
        projectedClimbLevelBox = findViewById(R.id.TextView23);
        teamNumBox = findViewById(R.id.teamNumber1);
        Finished = findViewById(R.id.finished);
        Finished.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v) {
                robotInfo = robotInfoBox.getText().toString();
                userThoughts = userThoughtsBox.getText().toString();
                projectedCycleTime = projectedCycleTimeBox.getText().toString();
                projectedClimbLevel = projectedClimbLevelBox.getText().toString();
                teamNum = teamNumBox.getText().toString();
                Log.d("pitscout", "TopRightbox: " + robotInfo);
                Log.d("pitscout","BottomRightbox: " + userThoughts);
                Log.d("pitscout", "TopLeftbox: " + projectedCycleTime);
                Log.d("pitscout","BottomLeftBox: " + projectedClimbLevel);
                Log.d("pitscout", "TeamNumBox" + teamNum);

               if(count7 == 1) {
                   navigate();
               }
               else{
                   Toast.makeText(ActivityPitScout.this, "You Must Take A Photo!", Toast.LENGTH_LONG).show();

               }



            }

        });
        Finished = findViewById(R.id.Activate_Camera);
        Finished.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v) {


                Activate_Camera();

                //onActivityResult();
            }


        });


    }


    public void navigate(){


        Log.d("pitData", teamNum + userThoughts + robotInfo + projectedCycleTime + projectedClimbLevel);

        if(robotInfo.length() < 1){
            robotInfo = "n/a";
        }
        if(userThoughts.length() < 1){
            userThoughts = "n/a";
        }
        if(projectedCycleTime.length() < 1){
            projectedCycleTime = "no projection";
        }
        if(projectedClimbLevel.length() < 1){
            projectedClimbLevel = "0";
        }

        ScoreDataBase SDB = ScoreDataBase.getDatabase(this);
        PitData pitData = new PitData(teamNum, "Scout's Thoughts: " + userThoughts, byteArray, "Robot Information: " + robotInfo, "Projected Cycle Time (in Secs): " + projectedCycleTime, "Projected Climb Level: " + projectedClimbLevel);

        SDB.pitDao().insertAll(pitData);

        Intent intent = new Intent(this, ActivityMain.class);
        startActivity(intent);

    }
    public void Activate_Camera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, RIC);
        } catch (ActivityNotFoundException e) {

            // display error state to the user
        }
    }
    @Override
    protected void onActivityResult ( int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RIC && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");


            ByteArrayOutputStream stream = new ByteArrayOutputStream();

            imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);

            byteArray = stream.toByteArray();


            //Bitmap code from Array to bitmap (needs imports).

            //Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);


            imageView.setImageBitmap(imageBitmap);



        }
    }

    public void OMG(){

    }





}

