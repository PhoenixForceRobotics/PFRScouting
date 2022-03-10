package edu.phoenixforce.scouting.mobile.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.fyrebirdscout11.R;

public class teamSelect extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("teamSelect","onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_select);
    }
}
