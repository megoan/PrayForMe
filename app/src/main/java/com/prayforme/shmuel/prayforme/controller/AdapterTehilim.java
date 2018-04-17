package com.prayforme.shmuel.prayforme.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.prayforme.shmuel.prayforme.R;

import java.util.ArrayList;

/**
 * Created by User on 12/04/2018.
 */

public class AdapterTehilim extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context context;
    ArrayList<String> items;
    ArrayList<String> perekNum;

    public AdapterTehilim(Context context, ArrayList items, ArrayList perekNum) {
        this.context = context;
        this.items = items;
        this.perekNum = perekNum;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tehilim_row_layout, parent, false);
        return new AdapterTehilim.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder)holder).textView.setText(items.get(position));
        ((ViewHolder)holder).perekNumTextView.setText(perekNum.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        TextView perekNumTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.tehilim);
            perekNumTextView=(TextView)itemView.findViewById(R.id.perekNumber);
        }
    }
}
