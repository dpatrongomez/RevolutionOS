package com.dpatrongomez.revolutionos;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Telegram extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telegram);
        Button bttelegram1 = findViewById(R.id.bttelegram1);
        Button bttelegram2 = findViewById(R.id.bttelegram2);
        Button bttelegram3 = findViewById(R.id.bttelegram3);
        Button bttelegram4 = findViewById(R.id.bttelegram4);
        Button bttelegram5 = findViewById(R.id.bttelegram5);


        bttelegram1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/RevolutionMIUI"));
                startActivity(browserIntent);
            }
        });
        bttelegram2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://t.me/RevolutionNews"));
                startActivity(browserIntent);
            }
        });
        bttelegram3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://t.me/ROSDownloads"));
                startActivity(browserIntent);
            }
        });
        bttelegram4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/RevolutionAOSP"));
                startActivity(browserIntent);
            }
        });
        bttelegram5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/RevolutionMIUIen"));
                startActivity(browserIntent);
            }
        });


    }
}

