package com.example.mysamll.app.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Test");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void jumpClick(View v){
        Intent intent = new Intent();
        intent.setClass(this,SubActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem mi){
        switch (mi.getItemId()) {
            case android.R.id.home:
                Toast.makeText(MainActivity.this, "不能退出啊", Toast.LENGTH_SHORT).show();
//                finish();
                return true;
            default:
                return super.onOptionsItemSelected(mi);
        }
    }

}
