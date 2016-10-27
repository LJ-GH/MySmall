package com.example.mysamll;

import android.app.Application;

import net.wequick.small.Small;

/**
 * Created by ljie on 16-10-20.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
//            Small.setBaseUri("http://example.com/");
        Small.preSetUp(this);
//        Small.setBaseUri("http://m.wequick.net/demo/");
    }
}
