package com.example.root.first;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {


    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView pname;
        TextView ppos;

        public PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            pname=(TextView) itemView.findViewById(R.id.pnameView);
            ppos=(TextView) itemView.findViewById(R.id.pposView);
        }
    }



    List<String> players ;

    int count;

    public RVAdapter(List<String> players,int count) {
        this.players = players;
        this.count = count;
    }



    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        holder.pname.setText(players.get(position));
        holder.ppos.setText("lala");

    }

    @Override
    public int getItemCount() {

        return count;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


}


