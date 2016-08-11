package com.example.zw.demolist.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zw.demolist.R;

/**
 * Created by zw on 2016/8/11.
 */
public class WFragmentOne extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.demo_fragment, container, false);

        TextView text= (TextView) view.findViewById(R.id.text);
        text.setText("第1个Fragment");

        return view;
    }
}
