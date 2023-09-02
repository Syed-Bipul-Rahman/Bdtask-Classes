package com.storedata.allviews;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;


public class PeopleFragment extends Fragment {
    private ListView listView;
    private SearchView searchView;
    ArrayAdapter<String> adapter;

    public PeopleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_people, container, false);

        searchView = view.findViewById(R.id.searchView);
        listView = view.findViewById(R.id.listViewid);
        String[] programming_language = getResources().getStringArray(R.array.programming_language);


        adapter = new ArrayAdapter<>(requireContext(), R.layout.sample_layout, R.id.textViewId, programming_language);
        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {


                adapter.getFilter().filter(s);

                return false;

            }
        });


        return view;
    }
}