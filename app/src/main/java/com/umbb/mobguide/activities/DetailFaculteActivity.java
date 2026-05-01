package com.umbb.mobguide.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.umbb.mobguide.R;
import com.umbb.mobguide.adapters.DepartmentAdapter;
import com.umbb.mobguide.models.DataManager;
import com.umbb.mobguide.models.Department;
import com.umbb.mobguide.models.Faculte;
import com.umbb.mobguide.models.Departement;
import java.util.ArrayList;

public class DetailFaculteActivity extends AppCompatActivity {

    private Faculte faculte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_faculte);

        String facultyName = getIntent().getStringExtra("faculty_name");
        faculte = findFacultyByName(facultyName);

        if (faculte == null) {
            Toast.makeText(this, "Faculty not found", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsingToolbar);
        collapsingToolbar.setTitle(faculte.getNom());

        ImageView imgHeader = findViewById(R.id.imgFacultyHeader);
        imgHeader.setImageResource(faculte.getImageResId());

        ((TextView) findViewById(R.id.tvFacultyDescription)).setText(faculte.getDescription());
        ((TextView) findViewById(R.id.tvFacultyEmail)).setText(faculte.getEmail());
        ((TextView) findViewById(R.id.tvFacultyPhone)).setText(faculte.getTelephone());

        RecyclerView rvDepartments = findViewById(R.id.rvDepartments);
        rvDepartments.setLayoutManager(new LinearLayoutManager(this));
        
        // Map Departement to Department for the adapter
        ArrayList<Department> departments = new ArrayList<>();
        for (Departement d : faculte.getDepartements()) {
            departments.add(new Department(d.getNom(), "Spécialités: " + d.getSpecialites().size(), d.getEmail(), d.getTelephone(), ""));
        }
        
        rvDepartments.setAdapter(new DepartmentAdapter(this, departments, department -> {
            // Handle click if needed, or leave empty
            Toast.makeText(this, department.getName(), Toast.LENGTH_SHORT).show();
        }));

        Button btnMap = findViewById(R.id.btnMap);
        Button btnContact = findViewById(R.id.btnContact);

        btnMap.setOnClickListener(v -> openMap());
        btnContact.setOnClickListener(v -> sendEmail());
    }

    private Faculte findFacultyByName(String name) {
        for (Faculte f : DataManager.getInstance().getFacultes()) {
            if (f.getNom().equals(name)) return f;
        }
        return null;
    }

    private void openMap() {
        String uri = "geo:" + faculte.getLatitude() + "," + faculte.getLongitude() + "?q=" + Uri.encode(faculte.getNom());
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    private void sendEmail() {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + faculte.getEmail()));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Inquiry: " + faculte.getNom());
        startActivity(Intent.createChooser(intent, "Send Email"));
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}