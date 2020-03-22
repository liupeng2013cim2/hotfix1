package com.andy.multidex.bean;

import android.util.Log;

/**
 * @ClassName: Bean
 * @Description: java类作用描述
 * @Author: andy
 * @Date: 2020/3/22 11:12
 */
public class Bean {
    private int id;
    private String name;
    public void println(String author) {
        Log.i("Bean", "original, id:" + id + ",name:" + name + ", author:" +author);
    }

}
