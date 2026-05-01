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
import com.google.android.material.button.MaterialButton;
import com.umbb.mobguide.R;
import com.umbb.mobguide.activities.FacultyListActivity;
import com.umbb.mobguide.models.University;
import java.util.ArrayList;

public class UniversityAdapter extends RecyclerView.Adapter<UniversityAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<University> universities;

    public UniversityAdapter(Context context, ArrayList<University> universities) {
        this.context = context;
        this.universities = universities;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_university_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        University university = universities.get(position);
        holder.txtName.setText(university.getName());
        holder.txtDetails.setText(university.getCity() + ", Algérie");
        holder.imgUniversity.setImageResource(university.getImageResId());

        View.OnClickListener clickListener = v -> {
            Intent intent = new Intent(context, FacultyListActivity.class);
            intent.putExtra("university_name", university.getName());
            context.startActivity(intent);
        };

        holder.itemView.setOnClickListener(clickListener);
        holder.btnVoir.setOnClickListener(clickListener);
    }

    @Override
    public int getItemCount() {
        return universities.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgUniversity;
        TextView txtName, txtDetails;
        MaterialButton btnVoir;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgUniversity = itemView.findViewById(R.id.imgUniversity);
            txtName = itemView.findViewById(R.id.txtUniversityName);
            txtDetails = itemView.findViewById(R.id.txtUniversityDetails);
            btnVoir = itemView.findViewById(R.id.btnVoirFacultes);
        }
    }
}