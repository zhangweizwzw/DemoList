package com.example.zw.demolist.widget;

import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.zw.demolist.R;

public class HideToolBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hide_tool_bar);

        initView();
    }

    private void initView(){
        final Toolbar toolbar = (Toolbar) findViewById(R.id.appbar_layout_toolbar);
//        StatusBarUtils.setTranslucentImageHeader(this,0,toolbar);
//        toolbar.setTitleTextColor(Color.TRANSPARENT);
//        toolbar.inflateMenu(R.menu.menu_search);

        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar_layout);
        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapse_layout);
        collapsingToolbarLayout.setTitle("aaa");
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.white));
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.white));
        collapsingToolbarLayout.setExpandedTitleColor(Color.TRANSPARENT);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                Log.e("zhangwei","appbarHeight:"+appBarLayout.getHeight()+" getTotalScrollRange:"+appBarLayout.getTotalScrollRange()+" offSet:"+verticalOffset);
                if(Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()){
                    toolbar.setTitleTextColor(getResources().getColor(R.color.white));
                    collapsingToolbarLayout.setTitle("AppbarLayout");
                }else{
                    collapsingToolbarLayout.setTitle("");
                }
            }
        });
    }
}
