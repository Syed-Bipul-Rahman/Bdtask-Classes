package com.classjob.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ftab1 extends Fragment {

    private RecyclerView recyclerView;
    private ChatAdapter adapter;
    private List<ChatModel> chatList;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public ftab1() {
        // Required empty public constructor
    }

    public static ftab1 newInstance(String param1, String param2) {
        ftab1 fragment = new ftab1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ftab1, container, false);

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize data source
        chatList = new ArrayList<>();

        // Initialize adapter
        adapter = new ChatAdapter(getContext(), (ArrayList<ChatModel>) chatList);
        recyclerView.setAdapter(adapter);

        // Add some initial data
        chatList.add(new ChatModel(R.drawable.hasina, "Apa", "Missed call", "10:00 AM"));
        chatList.add(new ChatModel(R.drawable.bipul, "Rakib", "Hello", "12:00 AM"));
        chatList.add(new ChatModel(R.drawable.imageme, "Nony Das", "Ki obosta", "3:00 AM"));
        chatList.add(new ChatModel(R.drawable.ic_splash, "Shakil Khan", "Kmn acis", "2:00 AM"));
        chatList.add(new ChatModel(R.drawable.mylogo, "Shanto choto", "Vai kajta ses", "9:00 AM"));

        // Notify the adapter of the data change
        adapter.notifyDataSetChanged();

        return view;
    }

    // Method to add data to the RecyclerView
    public void addData(ChatModel chatModel) {
        chatList.add(chatModel);
        adapter.notifyItemInserted(chatList.size() - 1); // Notify adapter of the new item
    }
}
