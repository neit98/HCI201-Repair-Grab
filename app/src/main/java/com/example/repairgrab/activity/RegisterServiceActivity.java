package com.example.repairgrab.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.repairgrab.R;

public class RegisterServiceActivity extends AppCompatActivity {

    private Dialog registerSuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_service);

        Toolbar toolbar = findViewById(R.id.toolbar_register);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        registerSuccess = new Dialog(this);
        registerSuccess.setContentView(R.layout.dialog_dkthanhcong);
        registerSuccess.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button registerok = registerSuccess.findViewById(R.id.btn_ok_register);
        registerok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RepairerMainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void register(View view) {
        registerSuccess.show();
    }
}
