package com.example.zw.demolist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.zw.adapter.DemolistAdapter;
import com.example.zw.bean.DemoBean;
import com.example.zw.demolist.widget.HideToolBarActivity;
import com.example.zw.recyclerview.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

import recyclepulltorefresh.RefreshRecyclerView;

public class MainActivity extends Activity implements DemolistAdapter.OnItemClickListener {
    private PullLoadMoreRecyclerView demolist;
    private List<DemoBean> clist=new ArrayList<DemoBean>();
    private DemolistAdapter mDemolistAdapter;
    private String strList[]=new String[]{"微信底部导航","QQ 6.0侧滑","多级滑动","向右滑动关闭activity","ButterKnife使用","小功能","隐藏toolbar","EventBus","RecyclerView应用","android热修复测试"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    /**
     * 初始化view
     */
    private void initView() {
        demolist= (PullLoadMoreRecyclerView) findViewById(R.id.demolist);
        demolist.setLinearLayout();
        demolist.setPullRefreshEnable(false);//设置是否下拉刷新
        demolist.setPushRefreshEnable(false);//设置是否上拉刷新
        mDemolistAdapter=new DemolistAdapter(this,clist);
        demolist.setAdapter(mDemolistAdapter);
        mDemolistAdapter.setOnItemClickListener(this);
    }



    /**
     * 初始化DATA
     */
    private void initData() {
        for (int i=0;i<strList.length;i++){
            DemoBean bean=new DemoBean();
            bean.setId(i+1);
            bean.setName(strList[i]);
            clist.add(bean);
        }
        mDemolistAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(View view, int position) {
        switch (clist.get(position).getId()){
             case 1:
                startActivity(new Intent(this,WeChatDHActivity.class));
            break;
            case 2:
                startActivity(new Intent(this,QqSlideMenuActivity.class));
            break;
            case 3:
                startActivity(new Intent(this,ManySlideFragmentActivity.class));
                break;
            case 4:
                startActivity(new Intent(this,RightSlideActivity.class));
                break;
            case 5:
                startActivity(new Intent(this,ButterKnifeActivity.class));
                break;
            case 6:
                startActivity(new Intent(this,UserfulActivity.class));
                break;
            case 7:
                startActivity(new Intent(this,HideToolBarActivity.class));
                break;
            case 8:
                startActivity(new Intent(this,EventBusActivity.class));
                break;
            case 9:
                startActivity(new Intent(this, RecyclerViewActivity.class));
                break;
            case 10:
                startActivity(new Intent(this, ApatchActivity.class));
                break;
        }
    }

    @Override
    public void onItemLongClick(View view, int position) {

    }
}
