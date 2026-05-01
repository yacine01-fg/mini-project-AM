package com.umbb.mobguide.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.umbb.mobguide.R;
import com.umbb.mobguide.adapters.DepartmentAdapter;
import com.umbb.mobguide.models.Department;
import com.umbb.mobguide.models.Faculty;

public class DepartmentListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_list);

        Faculty faculty = (Faculty) getIntent().getSerializableExtra("faculty_data");

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        if (faculty != null) {
            toolbar.setTitle(faculty.getName());
        }
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        setupBottomNavigation(R.id.nav_universities);

        RecyclerView rvDepartments = findViewById(R.id.rvDepartments);
        rvDepartments.setLayoutManager(new LinearLayoutManager(this));

        if (faculty != null) {
            DepartmentAdapter adapter = new DepartmentAdapter(this, faculty.getDepartments(), this::showDepartmentDetails);
            rvDepartments.setAdapter(adapter);
        }
    }

    private void showDepartmentDetails(Department dept) {
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_department_detail, null);
        
        TextView txtName = dialogView.findViewById(R.id.txtDetName);
        TextView txtSpecs = dialogView.findViewById(R.id.txtDetSpecs);
        MaterialButton btnCall = dialogView.findViewById(R.id.btnCall);
        MaterialButton btnEmail = dialogView.findViewById(R.id.btnEmail);
        MaterialButton btnMap = dialogView.findViewById(R.id.btnLocate);

        txtName.setText(dept.getName());
        txtSpecs.setText("Spécialités : " + dept.getSpecialties());

        btnCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + dept.getContactPhone()));
            startActivity(intent);
        });

        btnEmail.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:" + dept.getContactEmail()));
            startActivity(intent);
        });

        btnMap.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(dept.getLocationUrl()));
            startActivity(intent);
        });

        new AlertDialog.Builder(this)
                .setView(dialogView)
                .setPositiveButton("Fermer", null)
                .show();
    }
}
