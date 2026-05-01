package com.umbb.mobguide.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.umbb.mobguide.R;
import com.umbb.mobguide.activities.DepartmentListActivity;
import com.umbb.mobguide.models.Faculty;
import java.util.ArrayList;

public class FacultyAdapter extends RecyclerView.Adapter<FacultyAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<Faculty> faculties;

    public FacultyAdapter(Context context, ArrayList<Faculty> faculties) {
        this.context = context;
        this.faculties = faculties;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_faculty_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Faculty faculty = faculties.get(position);
        holder.txtName.setText(faculty.getName());
        holder.txtDeptCount.setText(faculty.getDepartmentCount() + " départements");
        holder.imgFaculty.setImageResource(faculty.getImageResId());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DepartmentListActivity.class);
            intent.putExtra("faculty_data", faculty);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return faculties != null ? faculties.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFaculty;
        TextView txtName, txtDeptCount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFaculty = itemView.findViewById(R.id.imgFaculty);
            txtName = itemView.findViewById(R.id.txtFacultyName);
            txtDeptCount = itemView.findViewById(R.id.txtDeptCount);
        }
    }
}