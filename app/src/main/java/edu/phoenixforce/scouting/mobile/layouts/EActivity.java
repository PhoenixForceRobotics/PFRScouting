package edu.phoenixforce.scouting.mobile.layouts;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fyrebirdscout11.R;

@SuppressLint("Registered")
public class EActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";
    public static final String EXTRA_REPLY1 = "com.example.android.wordlistsql.REPLY";

    private EditText mEditWordView;
    private Button mEditWordView1;

    public static int oof = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        mEditWordView = findViewById(R.id.edit_word);
        mEditWordView1 = findViewById(R.id.button_save1);
        oof = 0;

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditWordView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String word = mEditWordView.getText().toString();
                    setResult(RESULT_OK, replyIntent);
                    replyIntent.putExtra(EXTRA_REPLY, word);
                    Log.d("Night mode update", word);
                }
                finish();
               // goScoutIII();
            }
        });
        mEditWordView1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                oof = 1;
            }
        });

    }
   /* private void goScoutIII() {

        Intent intent = new Intent(this, RecyclerViewViewer.class);
        startActivity(intent);

    } */
}