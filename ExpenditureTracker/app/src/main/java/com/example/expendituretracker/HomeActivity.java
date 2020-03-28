package com.example.expendituretracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import customfonts.MyTextView_Roboto_Regular;


public class HomeActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private WrapContentHeightViewPager viewPager;
    Typeface mTypeface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ActivityCompat.requestPermissions(HomeActivity.this, new String[]{android.Manifest.permission.RECEIVE_SMS}, 1);
        //setToolbar();
        checkAndRequestPermissions();
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layout);

        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        tabLayout.addTab(tabLayout.newTab().setText("All"));
        //tabLayout.addTab(tabLayout.newTab().setText("Recieved"));
      //  tabLayout.addTab(tabLayout.newTab().setText("Sent"));




        mTypeface = Typeface.createFromAsset(this.getAssets(), "fonts/Roboto-Medium.ttf");
        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    ((TextView) tabViewChild).setTypeface(mTypeface, Typeface.NORMAL);
                }
            }
        }


        tabLayout.setTabGravity(TabLayout.MODE_SCROLLABLE);

        viewPager = (WrapContentHeightViewPager) findViewById(R.id.pager);
        CategoryPagerAdapter adapter = new CategoryPagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);


        viewPager.setOffscreenPageLimit(4);



        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });







//        SMSListener.bindListener(new Common.OTPListener() {
//            @Override
//            public void onOTPReceived(String extractedOTP) {
//
//                MyTextView_Roboto_Regular simpleEditText = (MyTextView_Roboto_Regular) findViewById(R.id.amount1);
//                simpleEditText.setText(extractedOTP);
//
//            }
//        });





    }

    private boolean checkAndRequestPermissions()
    {
        int sms = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS);
        int REQUEST_ID_MULTIPLE_PERMISSIONS =1;
        if (sms != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_SMS},REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }

    public void setCurrentTab(int i) {
        viewPager.setCurrentItem(i);
    }

//
//    private void setToolbar(){
//
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//
//        setSupportActionBar(toolbar);
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null)
//            actionBar.setDisplayHomeAsUpEnabled(false);
//
//        actionBar.setTitle("");

}
