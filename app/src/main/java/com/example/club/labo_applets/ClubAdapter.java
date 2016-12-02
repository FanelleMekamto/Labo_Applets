package com.example.club.labo_applets;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by club on 2016-11-11.
 */

public class ClubAdapter extends ArrayAdapter<Club> {

    List<Club> clubs;
    public ClubAdapter(Context context,List<Club> clubs) {
        super(context, 0, clubs);
        this.clubs=clubs;
    }

    @Nullable
    @Override
    public Club getItem(int position) {
        return clubs.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_clubs,parent, false);
        }

        ClubViewHolder viewHolder = (ClubViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new ClubViewHolder();
            viewHolder.nom = (TextView) convertView.findViewById(R.id.nom);
            viewHolder.local = (TextView) convertView.findViewById(R.id.local);
            viewHolder.logo = (ImageView) convertView.findViewById(R.id.logo);
            viewHolder.site = (TextView) convertView.findViewById(R.id.site);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        Club club = clubs.get(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.nom.setText(club.getNom());
        viewHolder.local.setText(club.getLocal());
        viewHolder.logo.setImageResource(club.getIcone());

        return convertView;
    }

    private class ClubViewHolder{
        public TextView local;
        public ImageView logo;
        public TextView nom;
        public TextView site;
    }
}
