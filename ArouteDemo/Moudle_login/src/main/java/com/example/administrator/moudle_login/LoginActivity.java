package com.example.administrator.moudle_login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.finddreams.module_base.entity.TestObj;
import com.finddreams.module_base.entity.TestParcelable;
import com.finddreams.module_base.utils.IHelloService;
import com.finddreams.module_base.utils.RouteUtils;

@Route(path = RouteUtils.User_Activity_Login)
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bt;


    @Autowired
    String name = "jack";
    @Autowired
    int age = 10;
    @Autowired
    int height = 175;
    @Autowired(name = "boy")
    boolean girl;
    @Autowired
    char ch = 'A';
    @Autowired
    float fl = 12.00f;
    @Autowired
    double dou = 12.01d;
    @Autowired
    TestParcelable pac;
    @Autowired
    TestObj obj;
    //    @Autowired
//    List<TestObj> objList;
//    @Autowired
//    Map<String, List<TestObj>> map;
    private long high;
    @Autowired
    String url;
    public static String TAG = "";
    private TextView tv_param;
    private TextView tv_value;

//    @Autowired(name = RouteUtils.Login_User)
//    IHelloService helloService;
//    @Autowired(name = RouteUtils.Service_User)
//    IUserModuleService userModuleService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = this.getClass().getSimpleName();
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

        //,objList=%s,map=%s
        String params = String.format(
                "name=%s,\n age=%s, \n height=%s,\n girl=%s,\n high=%s,\n url=%s,\n pac.name=%s," +
                        "\n obj.name=%s \n ch=%s \n fl = %s, \n dou = %s",
                name + "",
                age + "",
                height + "",
                girl + "",
                high + "",
                url + "",
                pac + "",
                obj + "",
                ch + "",
                fl + "",
                dou + ""
//                objList+"",
//                map+""
        );

        tv_param = (TextView) findViewById(R.id.tv_param);
        tv_value = (TextView) findViewById(R.id.tv_value);


        tv_param.setText(params);
//        IUserModuleService userModuleService = ARouter.getInstance().navigation(IUserModuleService.class);
//        if (userModuleService != null) {
//            tv_value.setText(userModuleService.getUserAddress("123"));
//        }

        IHelloService helloService = ARouter.getInstance().navigation(IHelloService.class);
        if (helloService != null) {
            tv_value.setText(helloService.getName());
        }

//        tv_value.setText(helloService.getName());

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt) {
            RouteUtils.startUserDetail();
        }
    }
}
