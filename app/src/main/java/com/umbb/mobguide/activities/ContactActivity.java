package com.umbb.mobguide.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.umbb.mobguide.R;
import com.google.android.material.button.MaterialButton;

public class ContactActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        setupBottomNavigation(R.id.nav_contact);

        MaterialButton btnCall = findViewById(R.id.btnCallSupport);
        MaterialButton btnEmail = findViewById(R.id.btnEmailSupport);
        MaterialButton btnWeb = findViewById(R.id.btnWeb);

        btnCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:024795201"));
            startActivity(intent);
        });

        btnEmail.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:contact@umbb.dz"));
            startActivity(intent);
        });

        btnWeb.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.univ-boumerdes.dz"));
            startActivity(intent);
        });
    }
}