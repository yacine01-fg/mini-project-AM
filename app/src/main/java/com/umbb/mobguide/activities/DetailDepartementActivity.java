package com.umbb.mobguide.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.umbb.mobguide.R;
import com.umbb.mobguide.models.DataManager;
import com.umbb.mobguide.models.Departement;
import com.umbb.mobguide.models.Faculte;

public class DetailDepartementActivity extends AppCompatActivity {

    private Departement departement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_departement);

        String deptName = getIntent().getStringExtra("dept_name");
        departement = findDepartmentByName(deptName);

        if (departement == null) {
            Toast.makeText(this, "Department not found", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsingToolbar);
        collapsingToolbar.setTitle(departement.getNom());

        ImageView imgHeader = findViewById(R.id.imgDeptHeader);
        imgHeader.setImageResource(departement.getImageResId());

        ((TextView) findViewById(R.id.tvDeptDescription)).setText(departement.getDescription());
        ((TextView) findViewById(R.id.tvDeptEmail)).setText(departement.getEmail());
        ((TextView) findViewById(R.id.tvDeptPhone)).setText(departement.getTelephone());

        ChipGroup cgSpecialties = findViewById(R.id.cgSpecialties);
        // Specialities are currently empty in DataManager, but here is how to add them
        if (departement.getSpecialites().isEmpty()) {
            addChip(cgSpecialties, "Licence");
            addChip(cgSpecialties, "Master");
            addChip(cgSpecialties, "Doctorat");
        } else {
            for (String spec : departement.getSpecialites()) {
                addChip(cgSpecialties, spec);
            }
        }

        findViewById(R.id.btnContactDept).setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + departement.getTelephone()));
            startActivity(intent);
        });
    }

    private void addChip(ChipGroup group, String text) {
        Chip chip = new Chip(this);
        chip.setText(text);
        chip.setCheckable(false);
        chip.setClickable(false);
        group.addView(chip);
    }

    private Departement findDepartmentByName(String name) {
        for (Faculte f : DataManager.getInstance().getFacultes()) {
            for (Departement d : f.getDepartements()) {
                if (d.getNom().equals(name)) return d;
            }
        }
        return null;
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}