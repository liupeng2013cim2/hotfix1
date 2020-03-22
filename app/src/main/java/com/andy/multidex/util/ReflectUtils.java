package com.andy.multidex.util;

import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName: ReflectUtils
 * @Description: java类作用描述
 * @Author: andy
 * @Date: 2020/3/22 12:08
 */
public class ReflectUtils {
    private static final String TAG = ReflectUtils.class.getSimpleName();

    public static Method getMethod(Object object, String methodName, Class<?>... parameterTypes) {
        Class clazz = object.getClass();
        while (clazz != null) {
            try {
                Method method = clazz.getDeclaredMethod(methodName, parameterTypes);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                return method;
            } catch (NoSuchMethodException e) {
                clazz = clazz.getSuperclass();
            }
        }
        return null;
    }

    public static Field getField(Object object, String filedName) {
        Class clazz = object.getClass();
        while (clazz != null) {
            try {
                Log.e(TAG, "getField, class:" + clazz.getName());
                Field field = clazz.getDeclaredField(filedName);
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                Log.e(TAG, "getFiled ok");
                return field;
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            }
        }
        return null;
    }

}
