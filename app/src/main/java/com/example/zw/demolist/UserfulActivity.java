package com.example.zw.demolist;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UserfulActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView text_blur,textView,banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userful);

        textView = (TextView) findViewById(R.id.textView);
        text_blur = (TextView) findViewById(R.id.text_blur);
        banner = (TextView) findViewById(R.id.banner);
        text_blur.setOnClickListener(this);
        banner.setOnClickListener(this);

        ClipboardManager clipboardService = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData primaryClip = clipboardService.getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            textView.setText(primaryClip.getItemAt(0).getText());
        }

        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(UserfulActivity.this, BigBangActivity.class);
                intent.putExtra(BigBangActivity.EXTRA_TEXT, textView.getText());
                startActivity(intent);
                return true;
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()){
            case R.id.text_blur:
                intent.setClass(this, BlurActivity.class);
                startActivity(intent);
                break;
            case R.id.banner:
                intent.setClass(this, BannerActivity.class);
                startActivity(intent);
                break;
        }
    }
}
