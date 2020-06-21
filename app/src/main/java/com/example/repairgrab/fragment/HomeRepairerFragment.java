package com.example.repairgrab.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.repairgrab.R;
import com.example.repairgrab.activity.RegisterServiceActivity;
import com.example.repairgrab.activity.RewardPointActivity;

public class HomeRepairerFragment extends Fragment {

    Button btnFindOrder;
    CardView repair, register, reward;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_repairer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        btnFindOrder = view.findViewById(R.id.btn_find_order);
//        btnFindOrder.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Fragment fragment = new ListOrderFragment();
//                FragmentManager fragmentManager = ((FragmentActivity)v.getContext()).getSupportFragmentManager();
//                FragmentTransaction transaction = fragmentManager.beginTransaction();
//
//                transaction
//                        .replace(R.id.fragment_container_repairer, fragment,fragment.getClass().getName().toString())
//                        .addToBackStack(null)
//                        .commit();
//
//            }
//        });

        repair = view.findViewById(R.id.card_repair);
        repair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new ListOrderFragment();
                FragmentManager fragmentManager = ((FragmentActivity)v.getContext()).getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                transaction
                        .replace(R.id.fragment_container_repairer, fragment,fragment.getClass().getName().toString())
                        .addToBackStack(null)
                        .commit();
            }
        });

        register = view.findViewById(R.id.cv_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RegisterServiceActivity.class);
                startActivity(intent);
            }
        });

        reward = view.findViewById(R.id.cv_reward_points);
        reward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RewardPointActivity.class);
                startActivity(intent);
            }
        });
    }
}
