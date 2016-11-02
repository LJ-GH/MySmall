package com.example.mysamllpluss.app.lovelyToast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ljs.lovelytoast.LovelyToast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LovelyToast.makeText(MainActivity.this, " SUCCESS!!", LovelyToast.LENGTH_SHORT,
                        LovelyToast.SUCCESS,LovelyToast.TOP_DOWN);
            }
        });
        findViewById(R.id.bt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LovelyToast.makeText(MainActivity.this, " Hi guys !",LovelyToast.LENGTH_SHORT , LovelyToast.WARNING, LovelyToast.SCALE , LovelyToast.RIGHT);
            }
        });
        findViewById(R.id.bt2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LovelyToast.makeText(MainActivity.this, " Hi guys !",LovelyToast.LENGTH_SHORT , LovelyToast.ERROR, LovelyToast.SCALE , LovelyToast.RIGHT);
            }
        });
        findViewById(R.id.bt3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LovelyToast.makeText(MainActivity.this, " Hi guys !",LovelyToast.LENGTH_SHORT , LovelyToast.CONFUSING, LovelyToast.SCALE , LovelyToast.RIGHT);
            }
        });
        findViewById(R.id.bt4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LovelyToast.makeText(MainActivity.this, " Hi guys !",LovelyToast.LENGTH_SHORT , LovelyToast.INFO, LovelyToast.SCALE , LovelyToast.RIGHT);
            }
        });
        findViewById(R.id.bt5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LovelyToast.makeText(MainActivity.this, " Hi guys !",LovelyToast.LENGTH_SHORT , LovelyToast.DEFAULT, LovelyToast.SCALE , LovelyToast.RIGHT);
            }
        });
    }
}
