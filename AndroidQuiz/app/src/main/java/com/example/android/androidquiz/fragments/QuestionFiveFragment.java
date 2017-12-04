package com.example.android.androidquiz.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.android.androidquiz.QuestionManager;
import com.example.android.androidquiz.R;

public class QuestionFiveFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_question_five, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().findViewById(R.id.submit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((QuestionManager) getActivity()).showNextQuestion(checkAnswer());
            }
        });
    }

    private boolean checkAnswer() {
        if (((RadioButton) getActivity().findViewById(R.id.cupcake_radio_button)).isChecked()) {
            return true;
        }
        return false;
    }

    private final String checkedRadioButtonID = "rdb";

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(checkedRadioButtonID, ((RadioGroup) getActivity().findViewById(R.id.radio_group)).getCheckedRadioButtonId());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            int index = savedInstanceState.getInt(checkedRadioButtonID);
            if (index > -1) {
                View radioView = ((RadioGroup) getActivity().findViewById(R.id.radio_group)).getChildAt(index);
                if (radioView != null) {
                    RadioButton radioButton = (RadioButton) getActivity().findViewById(radioView.getId());
                    if (radioButton != null)
                        radioButton.setSelected(true);
                }
            }
        }
    }
}
