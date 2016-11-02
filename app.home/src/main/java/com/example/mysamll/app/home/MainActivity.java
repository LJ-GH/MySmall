package com.example.mysamll.app.home;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.mysamll.app.fragment.FirstFragment;
import com.example.mysamll.app.fragment.SecondFragment;

import net.wequick.small.Small;

public class MainActivity extends AppCompatActivity {

    private TabLayout myTabLayout ;
    private ViewPager myViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvents();
//        setTitle("Home");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

//    public void homeClick(View v){
//        Toast.makeText(MainActivity.this,"home press",Toast.LENGTH_SHORT).show();
//        Small.setUp(this, new net.wequick.small.Small.OnCompleteListener() {
//
//            @Override
//            public void onComplete() {
//                Small.openUri("main", MainActivity.this);
//            }
//        });
////        Small.openUri("main",MainActivity.this);
//    }
//
//    public boolean onOptinosItemSelected(MenuItem menuItem){
//        switch(menuItem.getItemId()){
//            case android.R.id.home:
//                finish();
//                return true;
//            default:
//                return super.onOptionsItemSelected(menuItem);
//        }
//    }


    public void initView(){
        myTabLayout = (TabLayout) findViewById(R.id.myTabLayout);
        myViewPager = (ViewPager) findViewById(R.id.myViewPager);
        myViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            private String[] titles = {"首页","次页"};

            @Override
            public Fragment getItem(int position) {
                switch (position){
                    case 0:
                        return new FirstFragment();
                    case 1:
                        return new SecondFragment();
                    default:
                        return null;
                }
            }

            @Override
            public int getCount() {
                return titles.length;
            }

            @Override
            public CharSequence getPageTitle(int position){
                return titles[position];
            }

        });
        myTabLayout.setupWithViewPager(myViewPager);
    }

    private void initEvents(){
        myTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab == myTabLayout.getTabAt(0)){
                    myViewPager.setCurrentItem(0);
                }else if(tab == myTabLayout.getTabAt(1)){
                    myViewPager.setCurrentItem(1);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }



}
