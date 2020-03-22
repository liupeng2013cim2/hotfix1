package com.andy.multidex;

import android.app.Application;
import android.content.Context;

import com.andy.multidex.util.HookDexUtils;

/**
 * @ClassName: MyApplication
 * @Description: java类作用描述
 * @Author: andy
 * @Date: 2020/3/22 10:24
 */
public class MyApplication extends Application {
    private static final String TAG = MyApplication.class.getSimpleName();
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        HookDexUtils.setUp(base);
    }


}
