package edu.phoenixforce.scouting.mobile.database.recyclervewveiwers;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fyrebirdscout11.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import edu.phoenixforce.scouting.mobile.database.ViewModels.TeleView;
import edu.phoenixforce.scouting.mobile.database.adapters.TeleDataAdapter;
import edu.phoenixforce.scouting.mobile.database.entities.TeleData;
import edu.phoenixforce.scouting.mobile.layouts.ActivityMain;
import edu.phoenixforce.scouting.mobile.layouts.EActivity;
import edu.phoenixforce.scouting.mobile.layouts.TeleScore;


@SuppressLint("Registered")
public class RecyclerViewViewer extends AppCompatActivity {
    public static TeleView mWordViewModelII;
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bctivity_main32);

        mWordViewModelII = new ViewModelProvider(this).get(TeleView.class);

        TeleDataAdapter adapterII = new TeleDataAdapter(this);
        RecyclerView recyclerView1 = findViewById(R.id.recyclerview32);
        LinearLayoutManager llmII = new LinearLayoutManager(this);
        llmII.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView1.setLayoutManager(llmII);
        recyclerView1.setAdapter( adapterII );


        mWordViewModelII.getAllWords().observe(this, new Observer<List<TeleData>>(){
            @Override
            public void onChanged(List<TeleData> teleData) {
                adapterII.setData1(teleData);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecyclerViewViewer.this, ActivityMain.class);
                startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            /*
            TeleData teleData = new TeleData(String.valueOf(TeleScore.counter2),String.valueOf(TeleScore.counter3),String.valueOf(TeleScore.counter4),
                    String.valueOf(TeleScore.spunwheel),String.valueOf(TeleScore.colorwheel),String.valueOf(TeleScore.balls),
                    String.valueOf(TeleScore.solo),String.valueOf(TeleScore.buddy),String.valueOf(TeleScore.counter),String.valueOf(TeleScore.counter5));
                    */

                //TODO this /\
            //mWordViewModelII.insert(teleData);
            //Log.d("Night Mode Update", teleData.toString());
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }

}

