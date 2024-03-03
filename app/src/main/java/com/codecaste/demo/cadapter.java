package com.codecaste.demo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class cadapter extends RecyclerView.Adapter<cadapter.Viewholder> {

    Context context;
    ArrayList<String> cname;
    String name;

    public cadapter(Context context, ArrayList<String> cname, String name) {
        this.context = context;
        this.cname = cname;
        this.name = name;

    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.screenshot, parent, false);

        return new cadapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.tt.setText(cname.get(position));

        holder.tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (name.equals("main")) {
                    context.startActivity(new Intent(context, StateActivity.class).putExtra("country", cname.get(position)));

                } else if (name.equals("state")) {
                    context.startActivity(new Intent(context, CityActivity.class).putExtra("state", position).putExtra("list", cname));

                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return cname.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView tt;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            tt = itemView.findViewById(R.id.name);
        }
    }
}
