package com.programhorizon.demoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myListView = (ListView)findViewById(R.id.myListView);
        final ArrayList<String> myFriends = new ArrayList<String>();

        myFriends.add("Tristin");
        myFriends.add("Tavon");
        myFriends.add("Chris");
        myFriends.add("John");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myFriends);
        myListView.setAdapter(arrayAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Friend Clicked: " + myFriends.get(position), Toast.LENGTH_SHORT).show();
                Log.i("CLICKED", "Friend Clicked: " + myFriends.get(position)); // adding comment to when button clicked
            }
        });

    }

}
