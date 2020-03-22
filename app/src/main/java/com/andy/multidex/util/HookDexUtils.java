package com.andy.multidex.util;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: HookDexUtils
 * @Description: java类作用描述
 * @Author: andy
 * @Date: 2020/3/22 12:15
 */
public class HookDexUtils {
    public static final String TAG = HookDexUtils.class.getSimpleName();

    public static void setUp(Context context) {
        String path = FileUtils.copFile(context);
        hookDex(context, path);
    }

    public static boolean hookDex(Context context, String dexPath) {
        ClassLoader classLoader = context.getClassLoader();
        Field field = ReflectUtils.getField(classLoader, "pathList");
        if (field == null) {
            Log.e(TAG, "field is null");
            return false;
        }
        Object pathList = null;
        try {
            pathList = field.get(classLoader);
        } catch (IllegalAccessException e) {
            return false;
        }
        if (pathList == null) {
            Log.e(TAG, "pathList is null");
            return false;
        }

        Method makeDexElementsMethod = ReflectUtils.getMethod(pathList, "makeDexElements",
                List.class,
                File.class,
                List.class,
                ClassLoader.class);
        if (makeDexElementsMethod == null) {
            Log.e(TAG, "makeDexElements method is null");
            return false;
        }

//        Method addDexPathMethod = ReflectUtils.getMethod(pathList, "addDexPath",
//                String.class,
//                File.class
//                );
//        if (addDexPathMethod == null) {
//            Log.e(TAG, "makeDexElements method is null");
//            return false;
//        }
//        File optimizedDirectory = new File(context.getFilesDir(), "op_fixed_dex");
//        try {
//            addDexPathMethod.invoke(pathList, dexPath, optimizedDirectory);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }

        ArrayList<File> dexFiles = new ArrayList<>(1);
        dexFiles.add(new File(dexPath));
        File optimizedDirectory = new File(context.getFilesDir(), "op_dex");
        ArrayList<IOException> ioExceptions = new ArrayList<>(1);

        Object[] newElements = null;
        try {
            newElements = (Object[]) makeDexElementsMethod.invoke(pathList, dexFiles, optimizedDirectory, ioExceptions, classLoader);
        } catch (IllegalAccessException e) {
//            e.printStackTrace();
        } catch (InvocationTargetException e) {
//            e.printStackTrace();
        }
//
        Field dexElementsFiled = null;
        dexElementsFiled = ReflectUtils.getField(pathList, "dexElements");
        if (dexElementsFiled == null) {
            return false;
        }
        Object[] originalElements = null;
        try {
            originalElements = (Object[]) dexElementsFiled.get(pathList);
        } catch (IllegalAccessException e) {
            return false;
        }
        if (originalElements == null) {
            return false;
        }
        Object[] combineElements = (Object[]) Array.newInstance(originalElements[0].getClass(),
                originalElements.length + newElements.length
        );
        /**
         * 将补丁dex放在数组前面部分
         */
        System.arraycopy(newElements, 0, combineElements, 0, newElements.length);
        System.arraycopy(originalElements, 0, combineElements, newElements.length, originalElements.length);

        try {
            dexElementsFiled.set(pathList, combineElements);
        } catch (IllegalAccessException e) {
            return false;
        }
        return false;
    }
}
