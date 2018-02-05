package com.example.administrator.aroutedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.finddreams.module_base.utils.RouteUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt;
    private Button bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        bt = (Button) findViewById(R.id.bt);

        bt.setOnClickListener(this);
        bt2 = (Button) findViewById(R.id.bt2);
        bt2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt:
                RouteUtils.startLoginActivity();
                break;
            case R.id.bt2:
                RouteUtils.startUserDetail();
                break;
        }
    }
}
