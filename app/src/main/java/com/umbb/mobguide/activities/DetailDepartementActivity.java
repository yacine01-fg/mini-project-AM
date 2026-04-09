package com.umbb.mobguide.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.umbb.mobguide.R;
import com.umbb.mobguide.models.DataManager;
import com.umbb.mobguide.models.Departement;

public class DetailDepartementActivity extends AppCompatActivity {

    private Departement departement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_departement);

        int fIndex = getIntent().getIntExtra("faculte_index", 0);
        int dIndex = getIntent().getIntExtra("dept_index", 0);
        departement = DataManager.getInstance().getFacultes().get(fIndex).getDepartements().get(dIndex);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(departement.getNom());
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ((TextView) findViewById(R.id.tvDeptDetailNom)).setText(departement.getNom());
        ((TextView) findViewById(R.id.tvDeptDetailDesc)).setText(departement.getDescription());
        ((TextView) findViewById(R.id.tvDeptDetailEmail)).setText(departement.getEmail());
        ((TextView) findViewById(R.id.tvDeptDetailTel)).setText(departement.getTelephone());

        // Liste des spécialités
        ListView listSpec = findViewById(R.id.listViewSpecialites);
        ArrayAdapter<String> specAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, departement.getSpecialites());
        listSpec.setAdapter(specAdapter);

        // Boutons contact
        Button btnEmail = findViewById(R.id.btnDeptEmail);
        Button btnTel   = findViewById(R.id.btnDeptAppel);
        Button btnSms   = findViewById(R.id.btnDeptSms);

        btnEmail.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_SENDTO);
            i.setData(Uri.parse("mailto:" + departement.getEmail()));
            i.putExtra(Intent.EXTRA_SUBJECT, "Contact – " + departement.getNom());
            startActivity(Intent.createChooser(i, "Envoyer un e-mail"));
        });

        btnTel.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:" + departement.getTelephone()));
            startActivity(i);
        });

        btnSms.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("sms:" + departement.getTelephone()));
            startActivity(i);
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}