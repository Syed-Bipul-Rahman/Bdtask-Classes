package com.storedata.allviews;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;


public class HistoryFragment extends Fragment {

    VideoView videoView;

    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        videoView = view.findViewById(R.id.videoviewfr);


        Uri uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.videoplay);
        videoView.setVideoURI(uri); // Call setVideoURI on the videoView object, not VideoView class
        MediaController mediaController = new MediaController(getActivity());
        videoView.setMediaController(mediaController);

        videoView.start();

        return view;
    }
}