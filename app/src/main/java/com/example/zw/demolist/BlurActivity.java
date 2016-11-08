package com.example.zw.demolist;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.zw.demolist.R;
import com.example.zw.demolist.widget.BlurringView;

public class BlurActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blur);

        final BlurringView blurringView = (BlurringView) findViewById(R.id.blurringView);
        blurringView.setOverlayColor(Color.TRANSPARENT);
        View blurredView = findViewById(R.id.blurredView);
        blurringView.setBlurredView(blurredView);
        blurringView.setVisibility(View.VISIBLE);
    }
}
