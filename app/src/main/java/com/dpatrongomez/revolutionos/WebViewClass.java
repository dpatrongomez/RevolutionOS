package com.dpatrongomez.revolutionos;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class WebViewClass extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        Intent intent = getIntent();
        String numero = intent.getStringExtra(MainActivity.numero);
        String urlweb = "https://os.revtechs.me/";
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
        android.webkit.WebView web = findViewById(R.id.web);
        web.loadUrl(urlweb);
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setSupportZoom(true);
        web.getSettings().setUseWideViewPort(true);
        web.getSettings().setAllowContentAccess(true);
        web.getSettings().setAppCacheEnabled(true);
        web.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        web.getSettings().setDomStorageEnabled(true);
        web.getSettings().setAllowFileAccess(true);
        web.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        web.setWebViewClient(new WebViewClient());


        web.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimeType, long contentLength) {

                if(!check_permission(1)){
                    ActivityCompat.requestPermissions(WebViewClass.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE},2);
                }else {
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));

                    request.setMimeType(mimeType);
                    String cookies = CookieManager.getInstance().getCookie(url);
                    request.addRequestHeader("cookie", cookies);
                    request.addRequestHeader("User-Agent", userAgent);
                    request.setDescription(getString(R.string.dl_downloading));
                    request.setTitle(URLUtil.guessFileName(url, contentDisposition, mimeType));
                    request.allowScanningByMediaScanner();
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(url, contentDisposition, mimeType));
                    DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                    assert dm != null;
                    dm.enqueue(request);
                    Toast.makeText(getApplicationContext(), getString(R.string.dl_downloading2), Toast.LENGTH_LONG).show();
                }
            }
        });


    }
    public boolean check_permission(int permission){
        switch(permission){
            case 1:
                return ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;

        }
        return false;
    }
}
