package com.example.zw.demolist.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zw.bean.ShareBean;
import com.example.zw.demolist.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/1 0001.
 * 资讯
 */
public class ShareCommitItemFragment extends Fragment {

    private View view;
    List<ShareBean.DataBean> shares=new ArrayList<ShareBean.DataBean>();
    private Context context;
    public   int type;//  type=4 日常 type=5 吐槽  type=6  番剧 type=3  cos
    public SwipeRefreshLayout sf_lv_share_item_swipe_refresh;

    private boolean isLoad = false;
    private boolean hasMore = true;
    private String lastId; //最后一个ID
    private String lastTime;//最后一个的时间

    public static ShareCommitItemFragment newInstance(int types){

        ShareCommitItemFragment gameInfoFragment=new ShareCommitItemFragment();
        Bundle localBundle = new Bundle();
        localBundle.putInt("type", types);
        gameInfoFragment.setArguments(localBundle);
        return gameInfoFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_commit_share_item,container,false);
        Bundle bundle=getArguments();
        type=bundle.getInt("type",4);
        context=getActivity();
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void getAppIndexMore(String dateType, String pageNo3){
        isLoad =false;
        Log.d("zkk","---type"+dateType);
        //http://api.moeju.cn//painting/originalList?lastId=&lastTime=0&dk=5ed40069e20354be&ak=~68EECA63-0FB4-1EB8-628D-CDCF663CEB41&v=2.1.0&os=a&channel=Xiaomi
    }


    private void getAppIndexData(int dateType,int pageNo3){

        shares.clear();
        ShareBean list=null;


        if(list!=null&&list.getData()!=null&&list.getData().size()>0){
            lastId=list.getData().get(list.getData().size()-1).getId()+"";
            lastTime=list.getData().get(list.getData().size()-1).getCreateTime()+"";
        }
        getAppIndexData(type,0);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
