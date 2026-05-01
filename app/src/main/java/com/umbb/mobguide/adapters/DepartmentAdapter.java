package com.umbb.mobguide.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.umbb.mobguide.R;
import com.umbb.mobguide.models.Department;
import java.util.ArrayList;

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<Department> departments;
    private final OnDepartmentClickListener listener;

    public interface OnDepartmentClickListener {
        void onDepartmentClick(Department department);
    }

    public DepartmentAdapter(Context context, ArrayList<Department> departments, OnDepartmentClickListener listener) {
        this.context = context;
        this.departments = departments;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_department_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Department department = departments.get(position);
        holder.txtDeptName.setText(department.getName());
        holder.itemView.setOnClickListener(v -> listener.onDepartmentClick(department));
    }

    @Override
    public int getItemCount() {
        return departments != null ? departments.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtDeptName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDeptName = itemView.findViewById(R.id.txtDeptName);
        }
    }
}