package edu.phoenixforce.scouting.mobile.layouts;

import androidx.appcompat.app.AppCompatActivity;


import android.app.DownloadManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.fyrebirdscout11.R;







public class Settings extends AppCompatActivity {

    Button saver;

    EditText passw,teamnum,devnum;

    String password, teamnumber, devnumber;

    TextView printout;
    ImageView viewer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);






        /*teamnum = (EditText) findViewById(R.id.teamNum);

        teamnum.setOnEditorActionListener(new TextView.OnEditorActionListener(){

            @Override
            public boolean onEditorActiomn(TextView v, int actionId, KeyEvent event){


                if (actionId == EditorInfo.IME_NULL && event.getAction() == KeyEvent.ACTION_DOWN) {



                }

            }


        });*/



    }
}