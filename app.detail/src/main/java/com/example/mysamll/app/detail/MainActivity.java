package com.example.mysamll.app.detail;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {

    private ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SimpleAdapter simpleAdapter = new SimpleAdapter(
                this,getData(),
                R.layout.listview_item,
                new String[]{"img","text"},
                new int[]{R.id.detail_listview_img,R.id.detail_listview_text}
                );
        listView = (ListView) findViewById(R.id.detail_listView);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, ""+position, Toast.LENGTH_SHORT).show();
            }
        });
    }



    private List<Map<String,Object>> getData(){
        List list = new ArrayList();
        Map map;
        for(int i=0; i<25; i++){
            map = new HashMap();
            map.put("img",R.mipmap.ic_launcher);
            map.put("text","yoooo~~"+i);
            list.add(map);
        }
        return list;
    }

}
