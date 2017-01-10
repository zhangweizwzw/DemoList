package com.example.zw.demolist;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.zw.adapter.RecyclerAdapter;
import com.example.zw.bean.CoinBean;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import recyclepulltorefresh.OnNextPageListener;
import recyclepulltorefresh.RefreshRecyclerView;

public class RecyclerViewActivity extends AppCompatActivity implements RecyclerAdapter.OnItemClickListener{
    private final String TAG="RecyclerViewActivity";
    private RefreshRecyclerView mPullToRefreshView;
    private RecyclerAdapter mAdapter;
    /** 当前页数 每页十条 */
    private int mPage;
    // 是否刷新状态
    protected boolean isPullRefresh = false;
    private List<CoinBean.InfoBean> coin=new ArrayList<CoinBean.InfoBean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_refresh_linearlayout);


        mPullToRefreshView = (RefreshRecyclerView) findViewById(R.id.recycle_refresh);
        mPullToRefreshView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new RecyclerAdapter(this,coin);
        mPullToRefreshView.setAdapter(mAdapter);
        mPullToRefreshView.setRefreshEnable(true);
        mPullToRefreshView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
//                if (isPullRefresh) {// 如果正在刷新就返回
//                    return;
//                }
//                isPullRefresh = true;
                onRefresh1();
            }
        });
        mPullToRefreshView.setOnNextPageListener(new OnNextPageListener() {
            @Override
            public void onNextPage() {
                onNextPage1();
            }
        });
        mAdapter.setOnItemClickListener(this);
        onRefresh1();
    }

    protected void onRefresh1() {
        coin.clear();
        mPage = 0;
        netWorkRequest();
//        mPullToRefreshView.setLoadMoreEnable(false);
    }

    protected void onNextPage1() {
        mPage++;
        netWorkRequest();
    }

    private void netWorkRequest() {
        OkHttpUtils.post()
                .url("http://xy.1039.net:12345/drivingServcie/rest/driving_json/jjxc.ashx?")
                .addParams("methodName", "GetDriveCoin")
                .addParams("UserAccount","18612979798")
                .addParams("index",mPage+"")
                .addParams("remark","test")
                .addParams("sign", "2E394E3900D5EA6A6BAC686B849A94B0")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e) {
                        Toast.makeText(RecyclerViewActivity.this,"请求失败",Toast.LENGTH_LONG).show();
                        Log.i(TAG,"error");
                        mPullToRefreshView.refreshComplete();
                    }

                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(RecyclerViewActivity.this,"请求成功",Toast.LENGTH_LONG).show();
                        Gson gson=new Gson();
                        CoinBean cbean=new CoinBean();
                        cbean=gson.fromJson(response,CoinBean.class);
                        coin.addAll(cbean.getInfo());
                        Toast.makeText(RecyclerViewActivity.this,coin.size()+"\n"+"index="+mPage+1,Toast.LENGTH_LONG).show();
                        mAdapter.notifyDataSetChanged();
//                        if(mPage == 0) {
//                            mAdapter.resetList(coin);
//                        } else {
//                            mAdapter.addList(coin);
//                        }
//                        isPullRefresh = false;
                        mPullToRefreshView.refreshComplete();
                        mPullToRefreshView.setLoadMoreEnable(true);
                    }
                });
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(RecyclerViewActivity.this,"选中"+position,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemLongClick(View view, int position) {

    }
}
