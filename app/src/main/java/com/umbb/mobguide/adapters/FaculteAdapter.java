package com.umbb.mobguide.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.umbb.mobguide.R;
import com.umbb.mobguide.models.Faculte;

import java.util.ArrayList;

public class FaculteAdapter extends ArrayAdapter<Faculte> {

    private Context context;
    private ArrayList<Faculte> facultes;

    public FaculteAdapter(Context context, ArrayList<Faculte> facultes) {
        super(context, 0, facultes);
        this.context = context;
        this.facultes = facultes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_faculte, parent, false);
        }

        Faculte f = facultes.get(position);

        TextView tvNom = convertView.findViewById(R.id.tvFaculteNom);
        TextView tvDepts = convertView.findViewById(R.id.tvFaculteDepts);
        ImageView imgFaculte = convertView.findViewById(R.id.imgFaculte);

        tvNom.setText(f.getNom());
        int nbDepts = f.getDepartements().size();
        tvDepts.setText(nbDepts + " département" + (nbDepts > 1 ? "s" : ""));

        imgFaculte.setImageResource(f.getImageResId());

        return convertView;
    }

    public void updateData(ArrayList<Faculte> newData) {
        facultes.clear();
        facultes.addAll(newData);
        notifyDataSetChanged();
    }
}