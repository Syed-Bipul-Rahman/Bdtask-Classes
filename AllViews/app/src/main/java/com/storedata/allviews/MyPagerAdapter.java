package com.storedata.allviews;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter {
    private static final int NUM_PAGES = 3;

    public MyPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // Return the fragment associated with the specified position
        switch (position) {
            case 0:
                return new CallFragment();
            case 1:
                return new PeopleFragment();
            case 2:
                return new HistoryFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {

        return NUM_PAGES;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Return the title of each tab
        switch (position) {
            case 0:
                return "Spinner";
            case 1:
                return "Search";
            case 2:
                return "Video";
            default:
                return "";
        }
    }
}
