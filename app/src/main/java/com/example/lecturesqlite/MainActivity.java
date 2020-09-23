package com.example.lecturesqlite;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    MySQLiteDB mySQLiteDB;
    TextView results;
    EditText town;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        results = (TextView) findViewById(R.id.TV_Results);
        town = (EditText) findViewById(R.id.ET_town);
        mySQLiteDB = new MySQLiteDB(this);
    }

    public void Search(View view){
        if (town.getText().toString().matches("")) {
            Toast.makeText(this, "No town searched", Toast.LENGTH_LONG).show();
            return;
        }
        results.append("\n Towns beginning with " + town.getText()  + ":\n");
        results.append(mySQLiteDB.townBeginningWith(town.getText().toString()));
    }
}