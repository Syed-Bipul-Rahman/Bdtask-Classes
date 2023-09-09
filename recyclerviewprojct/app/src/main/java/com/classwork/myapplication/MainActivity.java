package com.classwork.myapplication;

import static com.classwork.myapplication.R.color.themeColor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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

        //change status bar color
//        getWindow().setStatusBarColor(R.color.themeColor);

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