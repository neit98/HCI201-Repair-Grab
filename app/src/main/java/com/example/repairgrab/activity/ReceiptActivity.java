package com.example.repairgrab.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.repairgrab.R;

public class ReceiptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);
    }

    public void clickToReceipt(View view) {
        Intent intent = new Intent(this, SummaryActivity.class);
        startActivity(intent);
    }

    public void clickToCancel(View view) {
    }
}
