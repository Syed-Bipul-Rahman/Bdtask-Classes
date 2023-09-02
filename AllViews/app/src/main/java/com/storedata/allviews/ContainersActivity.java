package com.storedata.allviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.storedata.allviews.databinding.ActivityContainersBinding;

public class ContainersActivity extends AppCompatActivity {
    ActivityContainersBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContainersBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();
        setContentView(view);

        TabLayout tabLayout = binding.tabslay;
        ViewPager viewPager = binding.viewpager;

        tabLayout.addTab(tabLayout.newTab().setText("People"));


        tabLayout.addTab(tabLayout.newTab().setText("Call"));
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        // Connect the TabLayout with the ViewPager.
        tabLayout.setupWithViewPager(viewPager);

    }
}