package com.example.club.labo_applets;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;

public class MainActivity extends OrmLiteBaseActivity<DatabaseHelper> {

    ListView mListView;
    //String[] nomsClubs=new String[]{"Applets","DronoLab","Conjure","Pirhana"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView=(ListView) findViewById(R.id.listView);

        try {
            Dao<Club, Integer> dao = getHelper().getClubDao();
            ArrayList<Club> clubArrayList = (ArrayList<Club>) dao.queryForAll();
            final ClubAdapter adapter=new ClubAdapter(MainActivity.this,  clubArrayList);
            mListView.setAdapter(adapter);


            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    Club club = adapter.getItem(i);

                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(club.getSite()));
                    startActivity(browserIntent);
                }
            });

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
