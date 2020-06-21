package com.example.repairgrab.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.repairgrab.R;
import com.example.repairgrab.activity.ConsultActivity;
import com.example.repairgrab.activity.MapsActivity;
import com.example.repairgrab.activity.NotifyErrorActivity;

public class HomeFragment extends Fragment {

    private CardView findRepairer, maintain, sales;


    @Override
    public void onStart() {
        super.onStart();
//        findRepairer = getActivity().findViewById(R.id.find_repairer);
//        findRepairer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), MapsActivity.class);
//                startActivity(intent);
//            }
//        });

        maintain = getActivity().findViewById(R.id.cv_maintain);
        maintain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ConsultActivity.class);
                startActivity(intent);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}
