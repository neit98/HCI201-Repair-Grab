package com.example.repairgrab.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.repairgrab.R;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
    }

    public void clickToFix(View view) {
    }

    public void clickToSend(View view) {
        Intent intent = new Intent(this, RepairerMainActivity.class);
        startActivity(intent);
    }

    public void clickToCancel(View view) {
    }
}
