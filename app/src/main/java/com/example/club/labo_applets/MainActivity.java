package com.example.club.labo_applets;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView mListView;
    //String[] nomsClubs=new String[]{"Applets","DronoLab","Conjure","Pirhana"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView=(ListView) findViewById(R.id.listView);
        List<Clubs> clubs = genererClubs();
        ClubAdapter adapter=new ClubAdapter(MainActivity.this, R.layout.row_clubs, clubs);
        mListView.setAdapter(adapter);
    }

    private List<Clubs> genererClubs(){
        List<Clubs> clubs = new ArrayList<Clubs>();
        clubs.add(new Clubs(Color.BLACK, "Applets", "A-1304"));
        clubs.add(new Clubs(Color.BLUE, "DronoLab", "A-1305"));
        clubs.add(new Clubs(Color.GREEN, "Conjure", "A-1306"));
        clubs.add(new Clubs(Color.RED, "Pirhana", "A-1307"));
        clubs.add(new Clubs(Color.GRAY, "Eclypse", "A-1308"));
        return clubs;
    }
}
