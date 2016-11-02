package com.example.mysamll.dailogUtil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hss01248.dialog.StyledDialog;
import com.hss01248.dialog.interfaces.MyDialogListener;

public class MainActivity extends AppCompatActivity {

    private String msg ="what the matter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StyledDialog.init(MainActivity.this);
                StyledDialog.buildMdAlert(MainActivity.this, "123", "235", new MyDialogListener() {
                    @Override
                    public void onFirst() {
                    }

                    @Override
                    public void onSecond() {

                    }
                });
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
