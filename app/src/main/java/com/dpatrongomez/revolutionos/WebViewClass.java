package com.dpatrongomez.revolutionos;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class WebViewClass extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        Intent intent = getIntent();
        String numero = intent.getStringExtra(MainActivity.numero);
        String urlweb = "https://os.revtechs.me/";;
        int n = Integer.parseInt(numero);

        switch (n) {
            case 1:
                urlweb = "https://os.revtechs.me/";
                break;
            case 2:
                urlweb = "https://os.revtechs.me/faq";
                break;
            case 3:
                urlweb = "https://bugs.revtechs.me/view_all_bug_page.php?filter=5c41019ad916e";
                break;
            case 4:
                urlweb = "https://os.revtechs.me/descargas-miui/";
                break;
            default:

                break;
        }
        android.webkit.WebView faq = findViewById(R.id.web);
        faq.loadUrl(urlweb);
        faq.getSettings().setJavaScriptEnabled(true);
        faq.getSettings().setSupportZoom(true);
        faq.getSettings().setUseWideViewPort(true);
        faq.getSettings().setAllowContentAccess(true);
        faq.getSettings().setAppCacheEnabled(true);
        faq.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        faq.getSettings().setDomStorageEnabled(true);
        faq.getSettings().setAllowFileAccess(true);
        faq.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        faq.setWebViewClient(new WebViewClient());
    }
}
