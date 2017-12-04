package com.example.android.androidquiz.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.androidquiz.QuestionManager;
import com.example.android.androidquiz.R;


public class QuestionTwoFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_question_two, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().findViewById(R.id.wrong_answer_1_image_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((QuestionManager) getActivity()).showNextQuestion(false);
            }
        });
        getActivity().findViewById(R.id.wrong_answer_2_image_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((QuestionManager) getActivity()).showNextQuestion(false);
            }
        });
        getActivity().findViewById(R.id.correct_answer_image_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((QuestionManager) getActivity()).showNextQuestion(true);
            }
        });
    }
}