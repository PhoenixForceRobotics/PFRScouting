package edu.phoenixforce.scouting.mobile.layouts;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.fyrebirdscout11.R;

public class ActivityPitScout extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {


    EditText topbox;
    EditText bottombox;
    Button Finished;
    Button Activate_Camera;
    ImageView imageView;
    static final int RIC = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pitscout);

        Finished = findViewById(R.id.finished);
        Finished.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v) {

                navigate();

            }

        });
        Finished = findViewById(R.id.Activate_Camera);
        Finished.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v) {

                Activate_Camera();

            }

        });


    }


    public void navigate(){
        Intent intent = new Intent(this, team_select.class);
        startActivity(intent);

    }
    public void Activate_Camera(){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, RIC);
        } catch (ActivityNotFoundException e) {

            // display error state to the user
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RIC && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }
    public void OMG(){

    }





}

