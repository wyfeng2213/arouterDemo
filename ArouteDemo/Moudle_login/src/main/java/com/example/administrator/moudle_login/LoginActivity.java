package com.example.administrator.moudle_login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.finddreams.module_base.utils.RouteUtils;

@Route(path = RouteUtils.User_Activity_Login)
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, LoginActivity.class);
        context.startActivity(starter);
    }

    private void initView() {
        bt = (Button) findViewById(R.id.bt);

        bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt) {
            RouteUtils.startUserDetail();
        }
    }
}
