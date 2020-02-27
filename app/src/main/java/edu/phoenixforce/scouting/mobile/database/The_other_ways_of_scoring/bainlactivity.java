package edu.phoenixforce.scouting.mobile.database.The_other_ways_of_scoring;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.fyrebirdscout11.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import edu.phoenixforce.scouting.mobile.layouts.EActivity;

import static java.util.Objects.requireNonNull;

@SuppressLint("Registered")
public class bainlactivity extends AppCompatActivity {

    private ViewModelII mWordViewModelII;
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bctivity_main2);

        mWordViewModelII = new ViewModelProvider(this).get(ViewModelII.class);

        ListAdapter adapterII = new ListAdapter(this);
        RecyclerView recyclerView1 = findViewById(R.id.recyclerview2);
        LinearLayoutManager llmII = new LinearLayoutManager(this);
        llmII.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView1.setLayoutManager(llmII);
        recyclerView1.setAdapter( adapterII );


        mWordViewModelII.getAllWords().observe(this, new Observer<List<ClimberScore>>(){
            @Override
            public void onChanged(@Nullable final List<ClimberScore> wordsII) {
                adapterII.setWords(wordsII);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(bainlactivity.this, EActivity.class);
                startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            ClimberScore climberScore = new ClimberScore(EActivity.oof, 1, 1, 1);
            mWordViewModelII.insert(climberScore);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }

}
