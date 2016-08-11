package com.example.zw.demolist;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zw.common.GradualRadioGroup;
import com.example.zw.demolist.fragment.WFragmentFour;
import com.example.zw.demolist.fragment.WFragmentOne;
import com.example.zw.demolist.fragment.WFragmentThree;
import com.example.zw.demolist.fragment.WFragmentTwo;
import com.example.zw.utils.MyToast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class WeChatDHActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager viewPager;
    private GradualRadioGroup gradualRadioGroup;
    private TextView title_center;
    private ImageView title_left;
    private WFragmentOne mWFragmentOne;
    private WFragmentTwo mWFragmentTwo;
    private WFragmentThree mWFragmentThree;
    private WFragmentFour mWFragmentFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_we_chat_dh);

        initView();
        initData();
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        gradualRadioGroup = (GradualRadioGroup) findViewById(R.id.radiobar);
        title_center= (TextView) findViewById(R.id.title_center);
        title_center.setText("仿微信底部导航栏");
        title_left= (ImageView) findViewById(R.id.title_left);
        title_left.setVisibility(View.VISIBLE);
        title_left.setImageResource(R.drawable.btn_return);
        title_left.setOnClickListener(this);
    }

    private void initData() {
        List<Fragment> list = new ArrayList<>();
        mWFragmentOne=new WFragmentOne();
        mWFragmentTwo=new WFragmentTwo();
        mWFragmentThree=new WFragmentThree();
        mWFragmentFour=new WFragmentFour();
        list.add(mWFragmentOne);
        list.add(mWFragmentTwo);
        list.add(mWFragmentThree);
        list.add(mWFragmentFour);

        viewPager.setAdapter(new DemoPagerAdapter(getSupportFragmentManager(), list));
        gradualRadioGroup.setViewPager(viewPager);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.title_left:
                finish();
                break;
        }
    }

    class DemoPagerAdapter extends FragmentPagerAdapter {
        List<Fragment> mData;

        public DemoPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public DemoPagerAdapter(FragmentManager fm, List<Fragment> data) {
            super(fm);
            mData = data;
        }

        @Override
        public Fragment getItem(int position) {
            return mData.get(position);
        }

        @Override
        public int getCount() {
            return mData.size();
        }
    }


}
