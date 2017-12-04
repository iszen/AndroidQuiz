package com.example.android.androidquiz.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.android.androidquiz.QuestionManager;
import com.example.android.androidquiz.R;

public class QuestionSixFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_question_six, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().findViewById(R.id.submit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((QuestionManager) getActivity()).showNextQuestion(!((EditText) getActivity().findViewById(R.id.os_version_edittext)).getText().toString().matches(""));
            }
        });
    }
}
