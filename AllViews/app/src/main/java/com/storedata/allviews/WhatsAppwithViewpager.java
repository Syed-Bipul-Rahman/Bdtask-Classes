package com.storedata.allviews;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.storedata.allviews.databinding.ActivityWhatsAppwithViewpagerBinding;

import java.util.ArrayList;
import java.util.List;

public class WhatsAppwithViewpager extends AppCompatActivity {
    ActivityWhatsAppwithViewpagerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWhatsAppwithViewpagerBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);

        ViewPager viewPager=binding.viewpager;

        TabLayout tabLayout=binding.tablayout;


        tabLayout.setupWithViewPager(viewPager);


    }





    }
