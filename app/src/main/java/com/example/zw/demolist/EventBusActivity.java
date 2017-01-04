package com.example.zw.demolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zw.utils.MessageEvent;
import com.example.zw.utils.MyToast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.w3c.dom.Text;

public class EventBusActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView sendsorn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);

        Button gonext= (Button) findViewById(R.id.gonext);
        gonext.setOnClickListener(this);
        sendsorn= (TextView) findViewById(R.id.sendsorn);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this,EventBusNextActivity.class);
        startActivity(intent);
    }

    @Subscribe
    public void onEventMainThread(MessageEvent event){
        MyToast.show(this,event.message.toString());
        sendsorn.setText(event.message.toString());
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().unregister(this);
        }
    }
}
