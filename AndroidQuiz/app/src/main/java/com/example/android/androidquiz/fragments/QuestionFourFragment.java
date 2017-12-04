package com.example.android.androidquiz.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.android.androidquiz.QuestionManager;
import com.example.android.androidquiz.R;

/**
 * Created by izxmg on 02-Dec-17.
 */

public class QuestionFourFragment extends Fragment {

    CheckBox textViewCheckBox;
    CheckBox imageTextCheckBox;
    CheckBox imageViewCheckBox;
    CheckBox imageButtonCheckBox;
    CheckBox textButtonCheckBox;
    CheckBox editTextCheckBox;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_question_four, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Activity activity = getActivity();
        activity.findViewById(R.id.submit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((QuestionManager) getActivity()).showNextQuestion(checkAnswer());
            }
        });

        textViewCheckBox = (CheckBox) activity.findViewById(R.id.textview_checkbox);
        imageTextCheckBox = (CheckBox) activity.findViewById(R.id.imagetext_checkbox);
        imageViewCheckBox = (CheckBox) activity.findViewById(R.id.imageview_checkbox);
        imageButtonCheckBox = (CheckBox) activity.findViewById(R.id.imagebutton_checkbox);
        textButtonCheckBox = (CheckBox) activity.findViewById(R.id.textbutton_checkbox);
        editTextCheckBox = (CheckBox) activity.findViewById(R.id.edittext_checkbox);
    }

    private boolean checkAnswer() {


        if (!textViewCheckBox.isChecked()) {
            return false;
        } else if (!imageViewCheckBox.isChecked()) {
            return false;
        } else if (imageTextCheckBox.isChecked()) {
            return false;
        } else if (!imageButtonCheckBox.isChecked()) {
            return false;
        } else if (textButtonCheckBox.isChecked()) {
            return false;
        } else if (!editTextCheckBox.isChecked()) {
            return false;
        }
        return true;
    }

    private final String textViewCheckBoxId = "tvch";
    private final String imageTextCheckBoxId = "itch";
    private final String imageViewCheckBoxId = "ivch";
    private final String imageButtonCheckBoxId = "ibch";
    private final String textButtonCheckBoxId = "tbch";
    private final String editTextCheckBoxId = "etch";

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(textViewCheckBoxId, textViewCheckBox.isChecked());
        outState.putBoolean(imageTextCheckBoxId, imageTextCheckBox.isChecked());
        outState.putBoolean(imageViewCheckBoxId, imageViewCheckBox.isChecked());
        outState.putBoolean(imageButtonCheckBoxId, imageButtonCheckBox.isChecked());
        outState.putBoolean(textButtonCheckBoxId, textButtonCheckBox.isChecked());
        outState.putBoolean(editTextCheckBoxId, editTextCheckBox.isChecked());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            textViewCheckBox.setChecked(savedInstanceState.getBoolean(textViewCheckBoxId));
            imageTextCheckBox.setChecked(savedInstanceState.getBoolean(imageTextCheckBoxId));
            imageViewCheckBox.setChecked(savedInstanceState.getBoolean(imageViewCheckBoxId));
            imageButtonCheckBox.setChecked(savedInstanceState.getBoolean(imageButtonCheckBoxId));
            textButtonCheckBox.setChecked(savedInstanceState.getBoolean(textButtonCheckBoxId));
            editTextCheckBox.setChecked(savedInstanceState.getBoolean(editTextCheckBoxId));
        }
    }
}
