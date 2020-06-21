package com.example.repairgrab.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import com.example.repairgrab.R;

public class LoginActivity extends AppCompatActivity {

    private EditText edt_username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edt_username = findViewById(R.id.edt_username);

    }




    public void clickToLogin(View view) {
        String username = edt_username.getText().toString().trim();
        if (username.equals("duytien")) {
            Intent intent = new Intent(this, RepairerMainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

    }
}
