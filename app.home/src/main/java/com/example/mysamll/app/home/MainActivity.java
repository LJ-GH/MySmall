package com.example.mysamll.app.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import net.wequick.small.Small;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Home");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void homeClick(View v){
        Toast.makeText(MainActivity.this,"home press",Toast.LENGTH_SHORT).show();
        Small.setUp(this, new net.wequick.small.Small.OnCompleteListener() {

            @Override
            public void onComplete() {
                Small.openUri("main", MainActivity.this);
            }
        });
//        Small.openUri("main",MainActivity.this);
    }
}
