package com.example.root.first;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText nameInput;
    EditText posInput;
    MyDBHandler dbHandler;
    ProgressBar proBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = (EditText)findViewById(R.id.nameInput);
        posInput = (EditText)findViewById(R.id.posInput);
        dbHandler = new MyDBHandler(this,null,null,1);
        proBar = (ProgressBar)findViewById(R.id.proBar);
        proBar.setProgress(dbHandler.getCount());

    }

    public void fabClicked(View view){
        Intent intent = new Intent(this,AnotherList.class);
        startActivity(intent);
    }



    public void addButtonClicked(View view){
        // dbHandler.add needs an object parameter.
        Player player = new Player(posInput.getText().toString(),nameInput.getText().toString());
        dbHandler.addPlayer(player);
        proBar.setProgress(dbHandler.getCount());
        nameInput.setText("");
        posInput.setText("");
    }

    //Delete items
    public void delButtonClicked(View view){
        // dbHandler delete needs string to find in the db
        String inputText = nameInput.getText().toString();
        dbHandler.deleteProduct(inputText);
        proBar.setProgress(dbHandler.getCount());
        nameInput.setText("");
        posInput.setText("");
    }
}

