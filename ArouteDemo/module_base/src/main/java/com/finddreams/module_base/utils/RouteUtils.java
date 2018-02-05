package com.finddreams.module_base.utils;

import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;
import com.finddreams.module_base.entity.TestObj;
import com.finddreams.module_base.entity.TestParcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lx on 17-10-24.
 * 路由的工具类
 */

public class RouteUtils {
    public static final String GoodDetail_Activity_Main = "/gooddetail/main";
    public static final String Home_Fragment_Main = "/home/main";
    public static final String Find_Fragment_Main = "/find/main";
    public static final String User_Fragment_Main = "/user/main";

    public static final String ShoppingCart_Fragment_Main = "/shoppingcart/main";

    public static final String User_Activity_Login = "/login/main";
    public static final String User_Detail = "/user/detail";

//    public static final String User_Activity_Login = "/test/login";
//    public static final String User_Detail = "/test/detail";

    public static final String Service_User = "/user/loginservice";
    public static final String Login_User = "/user/loginservice2";

    public static Fragment getFindFragment() {
        Fragment fragment = (Fragment) ARouter.getInstance().build(Find_Fragment_Main).navigation();
        return fragment;
    }

    public static Fragment getUserFragment() {
        Fragment fragment = (Fragment) ARouter.getInstance().build(User_Fragment_Main).navigation();
        return fragment;
    }

    public static Fragment getHomeFragment() {
        Fragment fragment = (Fragment) ARouter.getInstance().build(Home_Fragment_Main).navigation();
        return fragment;
    }

    public static Fragment getShoppingCartFragment() {
        Fragment fragment = (Fragment) ARouter.getInstance().build(ShoppingCart_Fragment_Main).navigation();
        return fragment;
    }

    /**
     * 跳转到商品详情的页面
     *
     * @param goodName
     */
    public static void startGoodDetailActivity(String goodName) {
        ARouter.getInstance().build(GoodDetail_Activity_Main).withString("goodName", goodName).navigation();
    }

    /**
     * 跳转到登录界面
     */
    public static void startLoginActivity() {
        TestParcelable testParcelable = new TestParcelable("jack", 666);
        TestObj testObj = new TestObj("Rose", 777);
        List<TestObj> objList = new ArrayList<>();
        objList.add(testObj);

        Map<String, List<TestObj>> map = new HashMap<>();
        map.put("testMap", objList);

        ARouter.getInstance().build(User_Activity_Login)
                .withString("name", "老王")
                .withInt("age", 18)
                .withBoolean("boy", true)
                .withLong("high", 180)
                .withString("url", "https://a.b.c")
                .withParcelable("pac", testParcelable)
                .withSerializable("obj", testObj)
//                .withObject("objList", objList)
//                .withObject("map", map)
                .navigation();
    }

    /**
     * 跳转到用户详情界面
     */
    public static void startUserDetail() {
        ARouter.getInstance().build(User_Detail).navigation();
    }
}
