package com.example.root.first;

import android.app.Activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;


public class AnotherList extends Activity {

    MyDBHandler dbHandler;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        dbHandler = new MyDBHandler(this,null,null,1);

        String[] playersNames = dbHandler.printList();
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,playersNames);
        ListView listView  = (ListView) findViewById(R.id.anotherListView);
        listView.setAdapter(adapter);


        SearchView s = (SearchView)findViewById(R.id.searchView);

        s.setOnQueryTextListener(
                new SearchView.OnQueryTextListener(){

                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        AnotherList.this.adapter.getFilter().filter(newText);
                        return false;
                    }
                }
        );

    }


}
