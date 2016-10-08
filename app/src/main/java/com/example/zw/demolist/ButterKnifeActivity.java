package com.example.zw.demolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zw.utils.MyToast;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.InjectViews;
import butterknife.OnClick;

public class ButterKnifeActivity extends AppCompatActivity {
    @InjectView(R.id.text1)
    TextView text1;
    @InjectViews({R.id.text1,R.id.text2})
    List<TextView> textViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butter_knife);

        ButterKnife.inject(this);

        initView();

    }

    private void initView() {
        text1.setText("this is ButterKnife");
    }

    @OnClick({R.id.text1,R.id.text2})
    void doit(View view){
        switch (view.getId()){
            case R.id.text1:
                MyToast.show(this,"点击了文本1");
                break;
            case R.id.text2:
                MyToast.show(this,"点击了文本2");
                break;
        }

    }
}
