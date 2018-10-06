package com.monktree.drozee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class PreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        ArrayList<String> pref = new ArrayList<>();
        pref.add("Action");
        pref.add("Adventure");
        pref.add("Comedy");
        pref.add("Fiction");
        pref.add("Drama");
        pref.add("Sci-Fi");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.prefRV);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        RecyclerViewAdapter viewAdapter = new RecyclerViewAdapter(this, pref);
        recyclerView.setAdapter(viewAdapter);

    }
}
