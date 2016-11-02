package com.example.mysamllpluss.app.camera;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Environment;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;

public class MainActivity extends AppCompatActivity {

    private Camera camera;
    private Button button;
    private SurfaceView surfaceView;
    private SurfaceHolder.Callback callback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        surfaceView = (SurfaceView)findViewById(R.id.surfaceView);
        callback = new SurfaceHolder.Callback(){
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                startCamera();
            }
            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }
            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                stopCamera();
            }
        };
//        new Thread(){
//            @Override
//            public void run(){
//                try{
//                    Thread.sleep(2000);
//                    Log.i("camera:", System.currentTimeMillis()+"");
//                    camera.takePicture(null, null, new Camera.PictureCallback() {
//                        @Override
//                        public void onPictureTaken(byte[] data, Camera camera) {
//                            try {
//                                File filePath = new File(Environment.getExternalStorageDirectory(), "myCamera");
//                                if(!filePath.exists()) {
//                                    filePath.mkdirs();
//                                }
//                                File fileName = new File(filePath, System.currentTimeMillis() + ".jpg");
//                                fileName.createNewFile();
//                                FileOutputStream fos = new FileOutputStream(fileName);
//                                fos.write(data);
//                                fos.flush();
//                                fos.close();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    });
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//
//            }
//        }.start();
        surfaceView.getHolder().addCallback(callback);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                camera.takePicture(null, null, new Camera.PictureCallback() {
                    @Override
                    public void onPictureTaken(byte[] data, Camera camera) {
                        try {
                            File filePath = new File(Environment.getExternalStorageDirectory(), "myCamera");
                            if(!filePath.exists()) {
                                filePath.mkdirs();
                            }
                            File fileName = new File(filePath, System.currentTimeMillis() + ".jpg");
                            fileName.createNewFile();
                            FileOutputStream fos = new FileOutputStream(fileName);
                            fos.write(data);
                            fos.flush();
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
    public void startCamera(){
        camera = Camera.open();
        try {
            camera.setPreviewDisplay(surfaceView.getHolder());
            camera.setDisplayOrientation(90);
            camera.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void stopCamera(){
        camera.stopPreview();
        camera.release();
        camera = null;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == Activity.DEFAULT_KEYS_DIALER){
            // MainActivity接收Camera返回的消息，然后将已经写入的图片显示在ImageView内
//            imageView.setImageURI(Uri.fromFile(fileName));
        }
    }
}
