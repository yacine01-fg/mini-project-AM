package com.umbb.mobguide.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.umbb.mobguide.R;
import com.umbb.mobguide.models.Departement;

import java.util.ArrayList;

public class DepartementAdapter extends ArrayAdapter<Departement> {

    private Context context;
    private ArrayList<Departement> departements;

    public DepartementAdapter(Context context, ArrayList<Departement> departements) {
        super(context, 0, departements);
        this.context = context;
        this.departements = departements;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_departement, parent, false);
        }

        Departement d = departements.get(position);

        TextView tvNom = convertView.findViewById(R.id.tvDeptNom);
        TextView tvSpec = convertView.findViewById(R.id.tvDeptSpec);
        TextView tvInitiale = convertView.findViewById(R.id.tvDeptInitiale);

        tvNom.setText(d.getNom());
        int nbSpec = d.getSpecialites().size();
        tvSpec.setText(nbSpec + " spécialité" + (nbSpec > 1 ? "s" : ""));

        String initiale = d.getNom().substring(0, 1).toUpperCase();
        tvInitiale.setText(initiale);

        return convertView;
    }
}