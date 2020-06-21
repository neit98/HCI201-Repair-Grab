package com.example.repairgrab.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.repairgrab.R;

public class RepairActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair);
    }

    public void clickToAccept(View view) {
        Intent intent = new Intent(this, ReceiptActivity.class);
        startActivity(intent);
    }
}
