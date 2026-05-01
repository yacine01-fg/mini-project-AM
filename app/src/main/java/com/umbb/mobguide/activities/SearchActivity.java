package com.umbb.mobguide.activities;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputEditText;
import com.umbb.mobguide.R;
import com.umbb.mobguide.adapters.UniversityAdapter;
import com.umbb.mobguide.models.DataRepository;
import com.umbb.mobguide.models.University;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class SearchActivity extends BaseActivity {

    private UniversityAdapter adapter;
    private ArrayList<University> allUniversities;
    private ArrayList<University> filteredList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        setupBottomNavigation(R.id.nav_search);

        RecyclerView rvResults = findViewById(R.id.rvSearchResults);
        TextInputEditText editSearch = findViewById(R.id.editSearch);

        allUniversities = DataRepository.getInstance().getUniversities();
        filteredList = new ArrayList<>(allUniversities);
        
        adapter = new UniversityAdapter(this, filteredList);
        rvResults.setLayoutManager(new LinearLayoutManager(this));
        rvResults.setAdapter(adapter);

        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void filter(String text) {
        filteredList.clear();
        for (University u : allUniversities) {
            if (u.getName().toLowerCase().contains(text.toLowerCase()) || 
                u.getCity().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(u);
            }
        }
        adapter.notifyDataSetChanged();
    }
}