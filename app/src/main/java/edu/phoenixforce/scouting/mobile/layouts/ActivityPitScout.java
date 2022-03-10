package edu.phoenixforce.scouting.mobile.layouts;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.fyrebirdscout11.R;

import java.io.ByteArrayOutputStream;

import edu.phoenixforce.scouting.mobile.common.Constants;
import edu.phoenixforce.scouting.mobile.database.ScoreDataBase;

public class ActivityPitScout extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {
    String text1;
    String text2;
    String text3;
    String text4;
    String text5;
    EditText topRightBox;
    EditText bottomRightBox;
    EditText leftTopBox;
    EditText leftBottomBox;
    EditText teamNumber;
    Button Finished;
    Button Activate_Camera;
    ImageView imageView;
    static final int RIC = 1;

    Constants constants = new Constants();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pitscout);
        imageView = findViewById(R.id.imageView6);

        topRightBox = findViewById(R.id.textView9);
        bottomRightBox = findViewById(R.id.textView18);
        leftTopBox = findViewById(R.id.textView21);
        leftBottomBox = findViewById(R.id.textView23);
        teamNumber = findViewById(R.id.teamNumber1);
        Finished = findViewById(R.id.finished);
        Finished.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v) {
                text1 = topRightBox.getText().toString();
                text2 = bottomRightBox.getText().toString();
                text3 = leftTopBox.getText().toString();
                text4 = leftBottomBox.getText().toString();
                text5 = teamNumber.getText().toString();
                constants.setUserThoughts(text2);
                constants.setRobotInfo(text1);
                constants.setProjectedClimbLevel(text4);
                constants.setProjectedCycleTime(text3);
                constants.setProjectedCycleTime(text5);
                String one = constants.getRobotInfo();
                String two = constants.getUserThoughts();
                String three = constants.getProjectedClimbLevel();
                String four = constants.getProjectedCycleTime();
                String five = constants.getTeamNumber();
                Log.d("pitscout", "TopRightbox: " + one);
                Log.d("pitscout","BottomRightbox: " + two);
                Log.d("pitscout", "TopLeftbox: " + three);
                Log.d("pitscout","BottomLeftBox: " + four);
                Log.d("pitscout","TeamNumber " + five);
                navigate();


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
        Intent intent = new Intent(this, team_select.class);
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

                byte[] byteArray = stream.toByteArray();

                Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);


                imageView.setImageBitmap(bitmap);



            }
        }

    public void OMG(){

    }





}

