package com.storedata.allviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

import com.storedata.allviews.databinding.ActivityWebviewBinding;

public class WebviewActivity extends AppCompatActivity {
ActivityWebviewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityWebviewBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        WebViewClient webViewClient=new WebViewClient();
        binding.webviewt.setWebViewClient(webViewClient);

        binding.webviewt.loadUrl("https://www.google.com/search?q=syed+bipul");
        WebSettings webSettings=binding.webviewt.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
}