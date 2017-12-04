package com.example.android.androidquiz;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.example.android.androidquiz.fragments.QuestionFiveFragment;
import com.example.android.androidquiz.fragments.QuestionFourFragment;
import com.example.android.androidquiz.fragments.QuestionOneFragment;
import com.example.android.androidquiz.fragments.QuestionSixFragment;
import com.example.android.androidquiz.fragments.QuestionThreeFragment;
import com.example.android.androidquiz.fragments.QuestionTwoFragment;

import static com.example.android.androidquiz.R.id.root_layout;

public class QuizActivity extends AppCompatActivity implements QuestionManager {

    private final int QUESTIONS_NUMBER = 6;
    private int currentQuestionIndex = 1;
    private final String title = "Question %s of %s";
    private int correctAnswers = 0;

    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        setTitle(String.format(title, currentQuestionIndex, QUESTIONS_NUMBER));

        if (savedInstanceState == null) {
            currentFragment = new QuestionOneFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(root_layout, currentFragment).commit();
        }
    }

    @Override
    public void showNextQuestion(boolean wasAnsweredCorrectly) {
        if (wasAnsweredCorrectly)
            correctAnswers++;
        switch (currentQuestionIndex) {
            case 1:
                currentFragment = new QuestionTwoFragment();
                break;
            case 2:
                currentFragment = new QuestionThreeFragment();
                break;
            case 3:
                currentFragment = new QuestionFourFragment();
                break;
            case 4:
                currentFragment = new QuestionFiveFragment();
                break;
            case 5:
                currentFragment = new QuestionSixFragment();
                break;
            case 6:
                Intent intent = new Intent(this, ResultActivity.class);
                intent.putExtra(ResultActivity.RESULT_EXTRA, correctAnswers + " out of " + QUESTIONS_NUMBER);
                startActivity(intent);
                finish();
                break;
        }

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(root_layout, currentFragment).commit();
        setTitle(String.format(title, ++currentQuestionIndex, QUESTIONS_NUMBER));
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.quit);
        builder.setMessage(R.string.alert_text);

        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
            }
        });

        builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();

    }

    private final String currentIndexId = "current";
    private final String correctAnswersId = "correct";

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(currentIndexId, currentQuestionIndex);
        savedInstanceState.putInt(correctAnswersId, correctAnswers);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        currentQuestionIndex = savedInstanceState.getInt(currentIndexId);
        correctAnswers = savedInstanceState.getInt(correctAnswersId);
        setTitle(String.format(title, currentQuestionIndex, QUESTIONS_NUMBER));
    }
}
