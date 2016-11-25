package com.example.club.labo_applets;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends OrmLiteBaseActivity<DatabaseHelper> {

    ListView mListView;
    //String[] nomsClubs=new String[]{"Applets","DronoLab","Conjure","Pirhana"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView=(ListView) findViewById(R.id.listView);
        List<Club> clubs = genererClubs();

        try {
            Dao<Club, Integer> dao = getHelper().getClubDao();
            ArrayList<Club> clubArrayList = (ArrayList<Club>) dao.queryForAll();
            ClubAdapter adapter=new ClubAdapter(MainActivity.this,  clubArrayList);
            mListView.setAdapter(adapter);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<Club> genererClubs(){
        List<Club> clubs = new ArrayList<Club>();
        clubs.add(new Club(Color.BLACK, "Applets", "A-1304"));
        clubs.add(new Club(Color.BLUE, "DronoLab", "A-1305"));
        clubs.add(new Club(Color.GREEN, "Conjure", "A-1306"));
        clubs.add(new Club(Color.RED, "Pirhana", "A-1307"));
        clubs.add(new Club(Color.GRAY, "Eclypse", "A-1308"));
        return clubs;
    }
}
