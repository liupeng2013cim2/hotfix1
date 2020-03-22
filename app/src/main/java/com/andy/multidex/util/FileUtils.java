package com.andy.multidex.util;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName: FileUtils
 * @Description: java类作用描述
 * @Author: andy
 * @Date: 2020/3/22 16:33
 */
public class FileUtils {
    private static final String TAG = FileUtils.class.getSimpleName();

    public static String copFile(Context context) {
        /**
         * 只有cache dir有权限创建文件
         */
        File fileDir = new File(context.getCacheDir(), "dex");
        boolean result = fileDir.mkdir();
        Log.e(TAG, "result:" + result);
        //该目录下放置修复好的dex文件
        String name = "fixed.dex";
        String filePath = fileDir.getAbsolutePath() + File.separator + name;
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //搬家：把下载好的在sd卡里面的修复了的classes2.dex复制到应用目录
        InputStream is = null;
        FileOutputStream os = null;
        try {
            //复制并粘贴文件
            is = new FileInputStream(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + name);
            os = new FileOutputStream(filePath);
            int len = 0;
            byte[] buffer = new byte[1024];
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(is);
            close(os);
        }
        return filePath;
    }

    private static void close(Closeable closeable) {
        try {
            if (closeable != null)
                closeable.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
