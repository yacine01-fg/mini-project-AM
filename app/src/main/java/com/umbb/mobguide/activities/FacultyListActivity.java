package com.umbb.mobguide.activities;

import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.MaterialToolbar;
import com.umbb.mobguide.R;
import com.umbb.mobguide.adapters.FacultyAdapter;
import com.umbb.mobguide.models.DataRepository;
import com.umbb.mobguide.models.University;

public class FacultyListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_list);

        String universityName = getIntent().getStringExtra("university_name");
        University university = DataRepository.getInstance().getUniversityByName(universityName);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        if (university != null) {
            toolbar.setTitle("Facultés de " + university.getName());
        }
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        setupBottomNavigation(R.id.nav_universities);

        RecyclerView rvFaculties = findViewById(R.id.rvFaculties);
        rvFaculties.setLayoutManager(new GridLayoutManager(this, 2));

        if (university != null) {
            FacultyAdapter adapter = new FacultyAdapter(this, university.getFaculties());
            rvFaculties.setAdapter(adapter);
        }
    }
}