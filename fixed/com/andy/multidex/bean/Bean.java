package com.andy.multidex.bean;


/**
 * @ClassName: Bean
 * @Description: java
 * @Author: andy
 * @Date: 2020/3/22 11:12
 */
public class Bean {
    private int id;
    private String name;
    public void println(String author) {
        System.out.println( "fixed, id:" + id + ",name:" + name + ", author:" +author);
    }

}
