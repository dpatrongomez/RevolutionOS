package com.dpatrongomez.revolutionos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String numero = "1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btabout = findViewById(R.id.btabout);
        Button bttelegram = findViewById(R.id.bttelegram);
        Button btdonate = findViewById(R.id.btdonate);

        btdonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.paypal.me/BadWolfalfa"));
                startActivity(browserIntent);
            }
        });
        bttelegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Telegram.class);
                startActivity(intent);
            }
        });

    }
    public void sendWeb(View view) {
        Intent intent = new Intent(MainActivity.this, WebViewClass.class);
        String message = "1";
        intent.putExtra(numero, message);
        startActivity(intent);
    }
    public void sendFaq(View view) {
        Intent intent = new Intent(MainActivity.this, WebViewClass.class);
        String message = "2";
        intent.putExtra(numero, message);
        startActivity(intent);
    }
    public void sendError(View view) {
        Intent intent = new Intent(MainActivity.this, WebViewClass.class);
        String message = "3";
        intent.putExtra(numero, message);
        startActivity(intent);
    }
    public void sendRom(View view) {
        Intent intent = new Intent(MainActivity.this, WebViewClass.class);
        String message = "4";
        intent.putExtra(numero, message);
        startActivity(intent);
    }


}
