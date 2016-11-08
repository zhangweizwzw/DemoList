package com.example.zw.demolist;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RightSlideActivity extends SlidingActivity implements View.OnClickListener {
    private TextView title_center;
    private ImageView title_left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right_slide);

        initView();
    }

    private void initView() {
        title_center= (TextView) findViewById(R.id.title_center);
        title_center.setText("仿ios右滑close页面");
        title_left= (ImageView) findViewById(R.id.title_left);
        title_left.setVisibility(View.VISIBLE);
        title_left.setImageResource(R.drawable.btn_return);
        title_left.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.title_left:
                finish();
                break;
        }
    }
}
