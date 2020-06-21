package com.example.repairgrab.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.repairgrab.R;
import com.example.repairgrab.fragment.HistoryFragment;
import com.example.repairgrab.fragment.HomeFragment;
import com.example.repairgrab.fragment.HomeRepairerFragment;
import com.example.repairgrab.fragment.RepairerAccountFragment;

public class RepairerMainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repairer_main);

        bottomNav = findViewById(R.id.bottom_navigation_repaier);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_repairer, new HomeRepairerFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()) {
                        case R.id.nav_home_repairer:
                            selectedFragment = new HomeRepairerFragment();
                            break;
                        case R.id.nav_history_repairer:
                            selectedFragment = new HistoryFragment();
                            break;
                        case R.id.nav_user_repairer:
                            selectedFragment = new RepairerAccountFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_repairer, selectedFragment).commit();
//                    bottomNav.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);

                    return true;
                }
            };

    public void clickToChange(View view) {

    }
}
