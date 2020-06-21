package com.example.repairgrab.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.repairgrab.R;

public class RepairerHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair_home2);
    }

    public void clickToRepair(View view) {
        Intent intent = new Intent(this, AcceptRepairActivity.class);
        startActivity(intent);
    }
}
