package com.example.android.androidquiz.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.androidquiz.QuestionManager;
import com.example.android.androidquiz.R;
import com.example.android.androidquiz.list.AndroidVersionAdapter;
import com.example.android.androidquiz.list.ItemTouchHelperCallback;
import com.example.android.androidquiz.model.AndroidVersions;

import java.util.ArrayList;

public class QuestionOneFragment extends Fragment {

    private RecyclerView recyclerView;
    private AndroidVersionAdapter mAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question_one, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<String> androidVersionsList = new ArrayList<String>();
        for (int i = 0; i < AndroidVersions.androidVersions.length; ++i) {
            androidVersionsList.add(AndroidVersions.androidVersions[i]);
        }
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.list);
        mAdapter = new AndroidVersionAdapter(androidVersionsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        ItemTouchHelper.Callback callback =
                new ItemTouchHelperCallback(mAdapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);

        getActivity().findViewById(R.id.submit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((QuestionManager) getActivity()).showNextQuestion(mAdapter.isCorrectlyOrdered());
            }
        });
    }
}
