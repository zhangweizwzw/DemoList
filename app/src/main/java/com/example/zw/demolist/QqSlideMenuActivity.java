package com.example.zw.demolist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.zw.bean.ItemBean;
import com.example.zw.demolist.widget.DragLayout;
import com.example.zw.demolist.widget.RoundAngleImageView;
import com.example.zw.utils.ItemDataUtils;
import com.joanzapata.android.BaseAdapterHelper;
import com.joanzapata.android.QuickAdapter;
import com.nineoldandroids.view.ViewHelper;


public class QqSlideMenuActivity extends Activity {
    private DragLayout dl;
    private ListView lv;
    private RoundAngleImageView ivIcon;
    private QuickAdapter<ItemBean> quickAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qq_slide_menu);

        initView();
        initDragLayout();
    }

    private void initDragLayout() {
        dl = (DragLayout) findViewById(R.id.dl);
        dl.setDragListener(new DragLayout.DragListener() {
            //界面打开的时候
            @Override
            public void onOpen() {
            }
            //界面关闭的时候
            @Override
            public void onClose() {
            }

            //界面滑动的时候
            @Override
            public void onDrag(float percent) {
                ViewHelper.setAlpha(ivIcon, 1 - percent);
            }
        });
    }

    private void initView() {
        ivIcon = (RoundAngleImageView) findViewById(R.id.iv_icon);

        lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(quickAdapter=new QuickAdapter<ItemBean>(this,R.layout.item_left_layout, ItemDataUtils.getItemBeans()) {
            @Override
            protected void convert(BaseAdapterHelper helper, ItemBean item) {
                helper.setImageResource(R.id.item_img,item.getImg())
                        .setText(R.id.item_tv,item.getTitle());
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {
                Toast.makeText(QqSlideMenuActivity.this,"Click Item "+position,Toast.LENGTH_SHORT).show();
            }
        });
        ivIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                dl.open();
            }
        });
    }


}
