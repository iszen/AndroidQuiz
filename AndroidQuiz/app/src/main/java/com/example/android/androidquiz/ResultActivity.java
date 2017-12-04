package com.example.android.androidquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {
    public static final String RESULT_EXTRA = "result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle(R.string.your_result);
        ((TextView) findViewById(R.id.questions_result))
                .setText(getIntent().getStringExtra(RESULT_EXTRA));
    }

    public void restart(View view) {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
        finish();
    }

    public void showToast(View view) {
        Toast.makeText(this, "Here's your yummy toast!\n Your score is: " + getIntent().getStringExtra(RESULT_EXTRA), Toast.LENGTH_LONG).show();
    }
}
