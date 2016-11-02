package com.example.mysamll.app.okhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity:------>: ";
    private String tmp = "init";
    private OkHttpClient mOkHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ((Button) findViewById(R.id.id_bt_01)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getAsynHttp();
//                postAsynHttp();
                getAsyncHttp1();
            }
        });
    }

    private void getAsyncHttp1() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .build();
        Request request = new Request.Builder()
                .url("http://news-at.zhihu.com/api/4/start-image/1080*1776")
                .method("GET", null)
                .build();
        Call mcall = okHttpClient.newCall(request);
        mcall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                try {
                    final JSONObject jsonObject = new JSONObject(str);
                    final String img = jsonObject.getString("img");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, img, Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch (Exception e) {

                }
            }
        });

    }


    private void getAsynHttp() {
        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .build();
        /* 如果需要参数 , 在url后边拼接 :  ?a=aaa&b=bbb..... */
        Request.Builder requestBuilder = new Request.Builder().url("http://news-at.zhihu.com/api/4/start-image/1080*1776");
        //可以省略，默认是GET请求
        requestBuilder.method("GET", null);
        Request request = requestBuilder.build();
        Call mcall = mOkHttpClient.newCall(request);
        mcall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (null != response.cacheResponse()) {
//                    String str = response.cacheResponse().toString();
                    String str = response.body().string();
                    Log.i(TAG, "cache---" + str);
                } else {
//                    String str = response.networkResponse().toString();
                    String str = response.body().string();
                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Log.i(TAG, "img:  " + jsonObject.getString("img"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "请求成功", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void postAsynHttp() {
        mOkHttpClient = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("size", "10")
                .build();
        Request request = new Request.Builder()
                .url("http://api.1-blog.com/biz/bizserver/article/list.do")
                .post(formBody)
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                Log.i("wangshu", str);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "post请求成功", Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });
    }
}
