package com.example.root.first;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    TextView ansView;
    EditText nameInput;
    EditText posInput;
    MyDBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ansView = (TextView) findViewById(R.id.ansView);
        nameInput = (EditText)findViewById(R.id.nameInput);
        posInput = (EditText)findViewById(R.id.posInput);
        dbHandler = new MyDBHandler(this,null,null,1);
        printDatabase();

    }

    public void fabClicked(View view){
        Intent intent = new Intent(this,AnotherList.class);
        startActivity(intent);
    }

    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        ansView.setText(dbString);
        nameInput.setText("");
        posInput.setText("");
    }

    public void addButtonClicked(View view){
        // dbHandler.add needs an object parameter.
        Player player = new Player(posInput.getText().toString(),nameInput.getText().toString());
        dbHandler.addPlayer(player);
        printDatabase();
    }

    //Delete items
    public void delButtonClicked(View view){
        // dbHandler delete needs string to find in the db
        String inputText = nameInput.getText().toString();
        dbHandler.deleteProduct(inputText);
        printDatabase();
    }
}

