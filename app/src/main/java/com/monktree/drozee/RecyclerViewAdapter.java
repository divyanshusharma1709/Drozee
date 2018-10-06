package com.monktree.drozee;

import android.content.Context;
import android.graphics.ColorSpace;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter{
    private Context mContext;
    private ArrayList<String> preferences;



    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView pref;

        public MyViewHolder(View view) {
            super(view);
            pref = (TextView) view.findViewById(R.id.prefTV);
        }
    }
    public RecyclerViewAdapter(Context c, ArrayList<String> prefs) {
        mContext = c;
        preferences = prefs;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);
        final CheckBox checkBox = (CheckBox)itemView.findViewById(R.id.checkbox);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked())
                    checkBox.setChecked(false);
                else
                    checkBox.setChecked(true);
            }
        });

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        TextView tv = holder.itemView.findViewById(R.id.prefTV);
        tv.setText(preferences.get(position));
        final CheckBox checkBox = (CheckBox)holder.itemView.findViewById(R.id.checkbox);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked())
                    checkBox.setChecked(false);
                else
                    checkBox.setChecked(true);
            }
        });
    }

    @Override
    public int getItemCount() {
        return preferences.size();
    }
}
