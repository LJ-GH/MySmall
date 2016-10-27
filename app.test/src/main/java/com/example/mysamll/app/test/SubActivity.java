package com.example.mysamll.app.test;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import java.lang.reflect.Method;

public class SubActivity extends AppCompatActivity {

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setLogo(R.mipmap.ic_launcher);
        actionBar.setDisplayUseLogoEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem mi){
        switch (mi.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.find:
                Toast.makeText(SubActivity.this, "find button press", Toast.LENGTH_SHORT).show();
            case R.id.what:
                Toast.makeText(SubActivity.this, "what button press", Toast.LENGTH_SHORT).show();
            default:
                return super.onOptionsItemSelected(mi);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu mu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.setting,mu);
        return true;
    }


}
