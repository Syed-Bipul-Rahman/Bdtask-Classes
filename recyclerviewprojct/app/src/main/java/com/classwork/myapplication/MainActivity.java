package com.classwork.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Model> arrayList;
    RecyclerView recyclerView;
    Adapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerData();

        recyclerView = findViewById(R.id.recyclerviewmain);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);


        recyclerAdapter = new Adapter(this, arrayList);
        recyclerView.setAdapter(recyclerAdapter);


    }

    private void recyclerData() {
        arrayList = new ArrayList<>();
        arrayList.add(new Model(R.drawable.ic_splash, "This is simple text"));
        arrayList.add(new Model(R.drawable.ic_splash, "This is simple text"));
        arrayList.add(new Model(R.drawable.ic_splash, "This is simple text"));


    }
}