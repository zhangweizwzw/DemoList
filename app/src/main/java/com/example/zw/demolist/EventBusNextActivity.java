package com.example.zw.demolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zw.utils.MessageEvent;
import com.example.zw.utils.MyToast;

import org.greenrobot.eventbus.EventBus;

public class EventBusNextActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_next);

        Button sendm= (Button) findViewById(R.id.sendm);
        sendm.setOnClickListener(this);
        Button goback= (Button) findViewById(R.id.goback);
        goback.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sendm:
                EventBus.getDefault().post(new MessageEvent("send success!"));
                break;
            case R.id.goback:
                finish();
                break;
        }

    }
}
