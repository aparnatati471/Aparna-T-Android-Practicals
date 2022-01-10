package com.example.javakotlinpracticals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView=findViewById(R.id.listview);


        ArrayList<String> items=new ArrayList<>(5);
        items.add("Class");
        items.add("Object");
        items.add("Polymorphisam");
        items.add("Inheritance");
        items.add("Abstraction");

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items);
listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String sitem=(String)adapterView.getItemAtPosition(i);
                Toast.makeText(MainActivity2.this, "Selected Item:"+sitem, Toast.LENGTH_SHORT).show();
            }
        });
    }
}