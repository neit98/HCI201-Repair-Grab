package com.example.repairgrab.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ProgressBar;

import com.example.repairgrab.R;

public class RewardPointActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward_point);

        Toolbar toolbar = findViewById(R.id.toolbar_reward);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        ProgressBar progressBar = findViewById(R.id.onboarding_activity_progress_bar);
        progressBar.setProgress(80);
    }
}
