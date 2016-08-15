package com.example.zw.demolist.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.design.widget.TabLayout;


import com.example.zw.demolist.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/8/12.
 */
public class SlideFragment extends Fragment{
    private List<Fragment> mFragmentList = new ArrayList<>();

    private TabLayout tableLayout;
    private ViewPager viewPager;
    private ApnFragmentAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view=inflater.inflate(R.layout.fragmentfirst, container,false);
        mFragmentList.add(new AFragment());
        mFragmentList.add(new BFragment());
        mFragmentList.add(new CFragment());

        tableLayout = (TabLayout)view.findViewById(R.id.commit_tableLayout);
        viewPager = (ViewPager)view.findViewById(R.id.commit_viewPager);

        mAdapter = new ApnFragmentAdapter(getFragmentManager());
        viewPager.setAdapter(mAdapter);
        tableLayout.setupWithViewPager(viewPager);
        tableLayout.setTabMode(TabLayout.MODE_FIXED);

        return view;
    }

    private class ApnFragmentAdapter extends FragmentPagerAdapter {
        CharSequence[] TITLE = new CharSequence[]{"画作","分享","排行榜"};

        public ApnFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return TITLE.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLE[position];
        }
    }
}
