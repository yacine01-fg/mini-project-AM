package com.umbb.mobguide.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.umbb.mobguide.R;
import com.umbb.mobguide.models.Universite;

import java.util.ArrayList;

public class UniversiteAdapter extends ArrayAdapter<Universite> {

    private Context context;
    private ArrayList<Universite> universites;

    public UniversiteAdapter(@NonNull Context context, ArrayList<Universite> universites) {
        super(context, 0, universites);
        this.context = context;
        this.universites = universites;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_universite, parent, false);
        }

        Universite universite = universites.get(position);

        ImageView imgUniversite = convertView.findViewById(R.id.imgUniversite);
        TextView tvNom = convertView.findViewById(R.id.tvNomUniversite);
        TextView tvLieu = convertView.findViewById(R.id.tvLieuUniversite);

        imgUniversite.setImageResource(universite.getImageResId());
        tvNom.setText(universite.getNom());
        tvLieu.setText(universite.getLieu());

        return convertView;
    }
}
