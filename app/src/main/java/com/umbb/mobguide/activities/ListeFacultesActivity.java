package com.umbb.mobguide.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.umbb.mobguide.R;
import com.umbb.mobguide.adapters.FaculteAdapter;
import com.umbb.mobguide.models.DataManager;
import com.umbb.mobguide.models.Faculte;
import com.umbb.mobguide.models.Universite;

import java.util.ArrayList;

public class ListeFacultesActivity extends AppCompatActivity {

    private ListView listView;
    private FaculteAdapter adapter;
    private ArrayList<Faculte> allFacultes;
    private ArrayList<Faculte> filteredFacultes;
    private EditText etSearch;
    private int universiteId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_facultes);

        universiteId = getIntent().getIntExtra("universite_id", 1);
        Universite universite = DataManager.getInstance().getUniversiteById(universiteId);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Facultés – " + universite.getNom());
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        listView = findViewById(R.id.listViewFacultes);
        etSearch = findViewById(R.id.etSearch);

        allFacultes = universite.getFacultes();
        filteredFacultes = new ArrayList<>(allFacultes);

        adapter = new FaculteAdapter(this, filteredFacultes);
        listView.setAdapter(adapter);

        // Recherche en temps réel
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterFacultes(s.toString());
            }
            @Override public void afterTextChanged(Editable s) {}
        });

        // Clic sur une faculté
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Faculte selected = filteredFacultes.get(position);
            int indexInAll = allFacultes.indexOf(selected);
            Intent intent = new Intent(ListeFacultesActivity.this, DetailFaculteActivity.class);
            intent.putExtra("universite_id", universiteId);
            intent.putExtra("faculte_index", indexInAll);
            startActivity(intent);
        });
    }

    private void filterFacultes(String query) {
        filteredFacultes.clear();
        if (query.isEmpty()) {
            filteredFacultes.addAll(allFacultes);
        } else {
            String lower = query.toLowerCase();
            for (Faculte f : allFacultes) {
                if (f.getNom().toLowerCase().contains(lower) ||
                        f.getDescription().toLowerCase().contains(lower)) {
                    filteredFacultes.add(f);
                }
            }
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}