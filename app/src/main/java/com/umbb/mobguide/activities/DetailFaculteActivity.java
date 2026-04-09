package com.umbb.mobguide.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.umbb.mobguide.R;
import com.umbb.mobguide.adapters.DepartementAdapter;
import com.umbb.mobguide.models.DataManager;
import com.umbb.mobguide.models.Departement;
import com.umbb.mobguide.models.Faculte;

public class DetailFaculteActivity extends AppCompatActivity {

    private Faculte faculte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_faculte);

        int index = getIntent().getIntExtra("faculte_index", 0);
        faculte = DataManager.getInstance().getFacultes().get(index);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(faculte.getNom());
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Remplissage des TextViews
        ((TextView) findViewById(R.id.tvDetailNom)).setText(faculte.getNom());
        ((TextView) findViewById(R.id.tvDetailDescription)).setText(faculte.getDescription());
        ((TextView) findViewById(R.id.tvDetailEmail)).setText(faculte.getEmail());
        ((TextView) findViewById(R.id.tvDetailTel)).setText(faculte.getTelephone());
        ((TextView) findViewById(R.id.tvDetailAdresse)).setText(faculte.getAdresse());

        // ListView des départements
        ListView listDepts = findViewById(R.id.listViewDepartements);
        DepartementAdapter adapter = new DepartementAdapter(this, faculte.getDepartements());
        listDepts.setAdapter(adapter);

        listDepts.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(this, DetailDepartementActivity.class);
            intent.putExtra("faculte_index", index);
            intent.putExtra("dept_index", position);
            startActivity(intent);
        });

        // Boutons de contact
        Button btnEmail = findViewById(R.id.btnEmail);
        Button btnTel   = findViewById(R.id.btnAppel);
        Button btnSms   = findViewById(R.id.btnSms);
        Button btnMaps  = findViewById(R.id.btnMaps);

        btnEmail.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_SENDTO);
            i.setData(Uri.parse("mailto:" + faculte.getEmail()));
            i.putExtra(Intent.EXTRA_SUBJECT, "Contact – " + faculte.getNom());
            startActivity(Intent.createChooser(i, "Envoyer un e-mail"));
        });

        btnTel.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:" + faculte.getTelephone()));
            startActivity(i);
        });

        btnSms.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("sms:" + faculte.getTelephone()));
            startActivity(i);
        });

        btnMaps.setOnClickListener(v -> {
            String uri = "geo:" + faculte.getLatitude() + "," + faculte.getLongitude()
                    + "?q=" + Uri.encode(faculte.getNom() + ", Boumerdès");
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            i.setPackage("com.google.android.apps.maps");
            if (i.resolveActivity(getPackageManager()) != null) {
                startActivity(i);
            } else {
                // Fallback navigateur
                String url = "https://maps.google.com/?q=" + faculte.getLatitude() + "," + faculte.getLongitude();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}