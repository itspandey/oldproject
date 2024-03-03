package com.codecaste.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rec);
        ArrayList<String> coungtryname = new ArrayList<String>();
        coungtryname.add("china");
        coungtryname.add("australia");
        coungtryname.add("india");
        coungtryname.add("orhia");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cadapter cadapter = new cadapter(MainActivity.this, coungtryname,"main");
        recyclerView.setAdapter(cadapter);



    }
}