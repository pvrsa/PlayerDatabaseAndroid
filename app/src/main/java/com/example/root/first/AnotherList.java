package com.example.root.first;

import android.app.Activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AnotherList extends Activity {

    MyDBHandler dbHandler;

    RecyclerView rv;
    List<String> players;
    RVAdapter rvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        dbHandler = new MyDBHandler(this,null,null,1);


        rv = (RecyclerView)findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        String[] playersNames = dbHandler.printList();
        players = new ArrayList<>(Arrays.asList(playersNames));

        rvAdapter = new RVAdapter(players,players.size());
        rv.setAdapter(rvAdapter);

        SearchView s = (SearchView)findViewById(R.id.searchView);

        s.setOnQueryTextListener(
                new SearchView.OnQueryTextListener(){

                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        return false;
                    }
                }
        );

    }


}
