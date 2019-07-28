package com.akshansh.fireb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class gaana extends AppCompatActivity {
    String url="https://gaana.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaana);
        WebView wb=findViewById(R.id.webview);
        wb.getSettings().setJavaScriptEnabled(true);
        wb.getSettings().setDisplayZoomControls(true);
        wb.loadUrl(url);
    }
}