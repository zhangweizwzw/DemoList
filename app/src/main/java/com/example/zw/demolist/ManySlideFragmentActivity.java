package com.example.zw.demolist;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

import com.example.zw.demolist.fragment.SlideFragment;

public class ManySlideFragmentActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_many_slide_fragment);

        init();

    }

    private void init() {
        SlideFragment myStatisticsFragment = new SlideFragment();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        transaction.add(R.id.mfragment, myStatisticsFragment);
        transaction.commitAllowingStateLoss();
    }
}
