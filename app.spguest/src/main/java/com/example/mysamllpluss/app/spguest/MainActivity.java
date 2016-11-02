package com.example.mysamllpluss.app.spguest;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch(menuItem.getItemId()){
            case(android.R.id.home):
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    public void buttonClick(View v){
        SharedPreferences sp = getSharedPreferences("DataBase", Activity.MODE_PRIVATE);
//        SharedPreferences.Editor ed = sp.edit();
        String name = sp.getString("input","notnot");
        ((TextView)findViewById(R.id.showText)).setText(name);
    }
}
