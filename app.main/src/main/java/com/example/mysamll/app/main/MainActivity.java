package com.example.mysamll.app.main;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTablayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        setTitle("测试11");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initViews();
        initEvents();

    }

    private void initViews(){
        mTablayout = (TabLayout) findViewById(R.id.myTabLayout);
        mViewPager = (ViewPager) findViewById(R.id.myViewPager);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            private String[] mTitles = {"title1","title2","标题3"};

            @Override
            public Fragment getItem(int position) {
                if (position == 0) {
                    return new TwoFragment();
                } else if (position == 1) {
                    return new TwoFragment();
                }  else if (position == 2) {
                    return new ThereFragment();
                } else{
                    return new OneFragment();
                }
            }

            @Override
            public int getCount() {
                return mTitles.length;
            }

            @Override
            public CharSequence getPageTitle(int position){
                return mTitles[position];

            }
        });

        mTablayout.setupWithViewPager(mViewPager);
        mTablayout.getTabAt(0).setIcon(R.mipmap.ic_launcher);
    }

    private void initEvents(){
        mTablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab == mTablayout.getTabAt(0)){
                    mViewPager.setCurrentItem(0);
                }else if(tab == mTablayout.getTabAt(1)){
                    mViewPager.setCurrentItem(1);
                }else if(tab == mTablayout.getTabAt(2)){
                    mViewPager.setCurrentItem(2);
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this, "onTabUnselected: "+tab, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this, "onTabReselected: "+tab, Toast.LENGTH_SHORT).show();
            }
        });
    }


}
