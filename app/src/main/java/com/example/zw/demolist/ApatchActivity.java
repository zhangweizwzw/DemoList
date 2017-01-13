package com.example.zw.demolist;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zw.utils.MyToast;

public class ApatchActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView title_center;
    private ImageView title_left;
    private Button but1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apatch);

        initView();
    }

    private void initView() {
        title_center = (TextView) findViewById(R.id.title_center);
        title_center.setText("android热修复");
        title_left = (ImageView) findViewById(R.id.title_left);
        title_left.setVisibility(View.VISIBLE);
        title_left.setImageResource(R.drawable.btn_return);
        title_left.setOnClickListener(this);

        but1 = (Button) findViewById(R.id.but1);
        but1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_left:
                finish();
                break;
            case R.id.but1:
                MyToast.show(this,"已修复");
                break;
        }
    }

}
