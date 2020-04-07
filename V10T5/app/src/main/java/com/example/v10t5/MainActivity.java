package com.example.v10t5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView web;
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = findViewById(R.id.webView);
        text = findViewById(R.id.editText);

        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);

        text.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    if (text.getText().toString().equals("index.html")) {
                        web.loadUrl("file:///android_asset/" + text.getText());
                    }
                    else {
                        web.loadUrl("http://" + text.getText());
                    }
                    return true;
                }
                return false;
            }
        });
    }

    public void refresh (View v) {
        web.reload();
    }

    public void previous (View v) {
        if (web != null && web.canGoBack()) {
            web.goBack();
        }
    }

    public void next (View v) {
        if (web.canGoForward()) {
            web.goForward();
        }
    }

    public void executeShoutOut (View v) {
        web.evaluateJavascript("javascript:shoutOut()", null);
    }

    public void executeInitialize (View v) {
        web.evaluateJavascript("javascript:initialize()", null);
    }
}
