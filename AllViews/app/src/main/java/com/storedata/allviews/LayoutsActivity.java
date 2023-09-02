package com.storedata.allviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.storedata.allviews.databinding.ActivityLayoutsBinding;

import java.util.ArrayList;

public class LayoutsActivity extends AppCompatActivity {
    ActivityLayoutsBinding binding;
    ArrayList<ListViewModel> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLayoutsBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();
        setContentView(view);


        //adding data to listview

        dataList.add(new ListViewModel(R.drawable.x, "Rahim", "hi how are you"));
        dataList.add(new ListViewModel(R.drawable.priyotoma, "Karim", "what are you doing"));
        dataList.add(new ListViewModel(R.drawable.hollywood, "Mofiz", "hello"));
        dataList.add(new ListViewModel(R.drawable.jawan, "MD abul hosen", "whats up"));

        ListviewAdapter listviewAdapter = new ListviewAdapter(this, dataList);
        binding.listView.setAdapter(listviewAdapter);


        listviewAdapter.setOnItemClickListener(new ListviewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ListViewModel item) {

                Intent intent = new Intent(LayoutsActivity.this, MessengerDetails.class);
                intent.putExtra("imageResourceId", item.getImageResourceId());
                intent.putExtra("text1", item.getText1());
                intent.putExtra("text2", item.getText2());
                startActivity(intent);
            }
        });


    }
}