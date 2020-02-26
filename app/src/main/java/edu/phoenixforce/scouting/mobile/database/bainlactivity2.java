package edu.phoenixforce.scouting.mobile.database;

import android.annotation.SuppressLint;
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

import edu.phoenixforce.scouting.mobile.layouts.EActivity;

import static java.util.Objects.requireNonNull;

@SuppressLint("Registered")
public class bainlactivity2 extends AppCompatActivity {

    private ViewModel mWordViewModel;
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bctivity_main);

        mWordViewModel = new ViewModelProvider(this).get(ViewModel.class);

        WordListAdapter adapter = new WordListAdapter(this);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter( adapter );

        mWordViewModel.getAllWords().observe(this, new Observer<List<color_wheel>>(){
            @Override
            public void onChanged(@Nullable final List<color_wheel> words) {
                adapter.setWords(words);
            }
        });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(bainlactivity2.this, EActivity.class);
                startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
            }
        });
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            color_wheel color_wheel = new color_wheel(requireNonNull(data.getStringExtra(EActivity.EXTRA_REPLY)), "e");
            Log.d("Night mode update", color_wheel.getColorWheelCanSpin());
            mWordViewModel.insert(color_wheel);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }

}
