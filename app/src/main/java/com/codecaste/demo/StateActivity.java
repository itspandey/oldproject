package com.codecaste.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class StateActivity extends AppCompatActivity {


    ArrayList<String>statename=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state);


        String countryname = getIntent().getStringExtra("country");


        RecyclerView recyclerView = findViewById(R.id.rec2);


        if (countryname.equals("india")){

            statename.add("delhi");
            statename.add("bihar");
            statename.add("mp");
            statename.add("up");
        }

        if (countryname.equals("china")){

            statename.add("c1");
            statename.add("c2");
            statename.add("c3");
            statename.add("c4");
        }

        if (countryname.equals("australia")){

            statename.add("a1");
            statename.add("a2");
            statename.add("a3");
            statename.add("a4");
        }

        if (countryname.equals("orhia")){

            statename.add("o1");
            statename.add("o2");
            statename.add("o3");
            statename.add("o4");
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cadapter cadapter = new cadapter(StateActivity.this, statename,"state");
        recyclerView.setAdapter(cadapter);


    }
}