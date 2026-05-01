package com.umbb.mobguide.activities;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.umbb.mobguide.R;
import com.umbb.mobguide.adapters.UniversityAdapter;
import com.umbb.mobguide.models.DataRepository;
import com.umbb.mobguide.models.University;
import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupBottomNavigation(R.id.nav_home);

        RecyclerView rvUniversities = findViewById(R.id.rvUniversities);
        rvUniversities.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<University> universities = DataRepository.getInstance().getUniversities();
        UniversityAdapter adapter = new UniversityAdapter(this, universities);
        rvUniversities.setAdapter(adapter);
    }
}