package com.umbb.mobguide.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.umbb.mobguide.R;

public abstract class BaseActivity extends AppCompatActivity {

    protected BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void setupBottomNavigation(int currentItemId) {
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        if (bottomNavigationView != null) {
            bottomNavigationView.setSelectedItemId(currentItemId);
            bottomNavigationView.setOnItemSelectedListener(item -> {
                int id = item.getItemId();
                if (id == currentItemId) return false;

                Intent intent = null;
                if (id == R.id.nav_home) {
                    intent = new Intent(this, MainActivity.class);
                } else if (id == R.id.nav_universities) {
                    // Since MainActivity shows the university list, we can point there or to a specific list activity
                    intent = new Intent(this, MainActivity.class);
                } else if (id == R.id.nav_search) {
                    intent = new Intent(this, SearchActivity.class);
                } else if (id == R.id.nav_contact) {
                    intent = new Intent(this, ContactActivity.class);
                }

                if (intent != null) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivity(intent);
                    return true;
                }
                return false;
            });
        }
    }
}