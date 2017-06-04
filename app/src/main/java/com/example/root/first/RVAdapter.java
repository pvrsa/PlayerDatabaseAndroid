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



    private List<String> players;
    private List<String> fPlayers;


    public RVAdapter(List<String> players) {
        this.players = players;
        this.fPlayers = players;
    }


    public void filter(String newText) {
        fPlayers = new ArrayList<>();
        for (String lala : players){
            if(lala.toLowerCase().contains(newText.toLowerCase())){
                fPlayers.add(lala);
            }
        }
        notifyDataSetChanged();
    }



    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        holder.pname.setText(fPlayers.get(position));
        holder.ppos.setText("lala");

    }

    @Override
    public int getItemCount() {

        return fPlayers.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


}


