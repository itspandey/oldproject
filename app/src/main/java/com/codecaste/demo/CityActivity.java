package com.codecaste.demo;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CityActivity extends AppCompatActivity {

    ArrayList<String> cityname = new ArrayList<>();
    ArrayList<String> list = new ArrayList<>();

    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        int stateposition = getIntent().getIntExtra("state", 0);

        list = getIntent().getStringArrayListExtra("list");

        TextView statename = findViewById(R.id.cntryname);
        Button prev = findViewById(R.id.prev);
        Button next = findViewById(R.id.next);

        count = stateposition;
        statename.setText(list.get(stateposition) + "");

        //injujbn


        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count > 0) {
                    count--;
                    statename.setText(list.get(count));
                } else {
                    Toast.makeText(CityActivity.this, "Already at the first item", Toast.LENGTH_SHORT).show();
                    Log.e("Volley", "Invalid JSON Object.");
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count < list.size() - 1) {
                    count++;
                    statename.setText(list.get(count));
                } else {
                    Toast.makeText(CityActivity.this, "Already at the last item", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}