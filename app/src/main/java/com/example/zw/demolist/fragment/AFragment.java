package com.example.zw.demolist.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zw.demolist.R;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zw on 2016/8/12.
 */
public class AFragment extends Fragment {
    private List<Fragment> mFragmentList = new ArrayList<>();

    private TabLayout tableLayout;
    private ViewPager viewPager;
    private ApnFragmentAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.demo_fragment, container, false);

        mFragmentList.add(new A1Fragment());
        mFragmentList.add(new A2Fragment());
        mFragmentList.add(new A3Fragment());

        tableLayout = (TabLayout)view.findViewById(R.id.commit_tableLayout_share);
        viewPager = (ViewPager)view.findViewById(R.id.commit_viewPager_share);

        mAdapter = new ApnFragmentAdapter(getFragmentManager());
        viewPager.setAdapter(mAdapter);
        tableLayout.setupWithViewPager(viewPager);
        tableLayout.setTabMode(TabLayout.MODE_FIXED);

        return view;
    }

    private class ApnFragmentAdapter extends FragmentPagerAdapter {
        CharSequence[] TITLE = new CharSequence[]{"A1","A2","A3"};

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
