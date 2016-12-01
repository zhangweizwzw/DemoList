package com.example.zw.demolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.zw.bean.BannerModel;
import com.example.zw.demolist.widget.BGABanner;

import java.util.ArrayList;
import java.util.List;

public class BannerActivity extends AppCompatActivity implements BGABanner.OnItemClickListener, BGABanner.Adapter{
    private BGABanner banner_main_default;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);

        banner_main_default = (BGABanner) findViewById(R.id.banner_main_default);
        List imgs=new ArrayList();
        imgs.add("http://7xk9dj.com1.z0.glb.clouddn.com/banner/imgs/12.png");
        imgs.add("http://7xk9dj.com1.z0.glb.clouddn.com/banner/imgs/13.png");
        imgs.add("http://7xk9dj.com1.z0.glb.clouddn.com/banner/imgs/14png");
        imgs.add("http://7xk9dj.com1.z0.glb.clouddn.com/banner/imgs/15.png");
        List tips=new ArrayList();
        tips.add("第一页的提示文案");
        tips.add("第二页的提示文案");
        tips.add("第三页的提示文案");
        tips.add("第四页的提示文案");
        banner_main_default.setAdapter(BannerActivity.this);
        banner_main_default.setData(imgs,tips);
        banner_main_default.setOnItemClickListener(this);
    }

    @Override
    public void fillBannerItem(BGABanner banner, View view, Object model, int position) {
        Glide.with(BannerActivity.this)
                .load(model)
                .placeholder(R.drawable.holder)
                .error(R.drawable.holder)
                .into((ImageView) view);
    }

    @Override
    public void onBannerItemClick(BGABanner banner, View view, Object model, int position) {
        Toast.makeText(BannerActivity.this, "点击了第" + (position + 1) + "页", Toast.LENGTH_SHORT).show();
    }
}
