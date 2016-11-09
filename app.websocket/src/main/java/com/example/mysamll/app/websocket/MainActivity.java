package com.example.mysamll.app.websocket;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.UiThread;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import de.tavendo.autobahn.WebSocketConnection;
import de.tavendo.autobahn.WebSocketException;
import de.tavendo.autobahn.WebSocketHandler;

public class MainActivity extends AppCompatActivity {

    private final WebSocketConnection mConnection = new WebSocketConnection();
    private String TAG = "MainActivity";
    private Button button;
    private Button sendButton;
    private TextView textView;
    private EditText editText;
    private Handler mHandler;
    private ScrollView scrollView;
    private EditText editTextUserId;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        button = (Button)findViewById(R.id.button1);
        sendButton = (Button) findViewById(R.id.buttonSend);
        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView1);
        scrollView = (ScrollView) findViewById(R.id.scrollView1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editContent =  editText.getText().toString();
                editText.setText("");
                mConnection.sendTextMessage(editContent);
            }
        });

        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                //操作界面
                textView.setText( "ok");
                super.handleMessage(msg);
            }
        };
        Dialog dialog = new AlertDialog.Builder(this).setTitle("请输入用户id")
                .setIcon(android.R.drawable.ic_dialog_info)
                .setView(editTextUserId = new EditText(this))
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        userId = editTextUserId.getText().toString();
                    }
                }).setNegativeButton("取消", null)
                .show();

    }

    private void start() {

        final String wsuri = "ws://192.168.1.60:8080//ws?uid="+userId;

        try {
            mConnection.connect(wsuri, new WebSocketHandler() {

                @Override
                public void onOpen() {
                    Log.d(TAG, "Status: Connected to " + wsuri);
                    mConnection.sendTextMessage("android: onOpen");
                }

                @Override
                public void onTextMessage(String payload) {
                    textView.append("\n"+payload);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                        }
                    });
//                    Message message = new Message();
//                    mHandler.sendMessage(message);
                    Log.d(TAG, "Got echo: " + payload);
                }

                @Override
                public void onClose(int code, String reason) {
                    Log.d(TAG, "Connection lost.");
                }
            });
        } catch (WebSocketException e) {

            Log.d(TAG, e.toString());
        }
    }

}
