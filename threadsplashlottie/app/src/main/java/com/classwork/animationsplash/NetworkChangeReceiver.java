package com.classwork.animationsplash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.snackbar.Snackbar;

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        CoordinatorLayout coordinatorLayout = ((MainActivity) context).findViewById(R.id.coordinatorlayout);
        try {
            if (isOnline(context)) {
                Toast.makeText(context, "Internet Available", Toast.LENGTH_LONG).show();
                showSnackbar(coordinatorLayout, "Internet Available");
            } else {
                Toast.makeText(context, "No Internet Available", Toast.LENGTH_LONG).show();
                showSnackbar(coordinatorLayout, "No Internet Available");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    private void showSnackbar(CoordinatorLayout coordinatorLayout, String internet_available) {
        //make all snackbar dismissable
        Snackbar snackbar = Snackbar.make(coordinatorLayout, internet_available, Snackbar.LENGTH_LONG);
        snackbar.setAction("Dismiss", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        }).setActionTextColor(coordinatorLayout.getResources().getColor(android.R.color.holo_red_light));
        snackbar.show();


    }

    private boolean isOnline(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            return (networkInfo != null && networkInfo.isConnected());


        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }


}