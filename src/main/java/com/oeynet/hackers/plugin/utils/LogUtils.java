package com.oeynet.hackers.plugin.utils;

import android.util.Log;

/**
 * Created by ZengYinan.
 * Date: 2019/3/17 15:36
 * Email: 498338021@qq.com
 * Desc:
 */
public class LogUtils {
    public static void s(String tag, String str) {
        str = str.trim();
        int index = 0;
        int maxLength = 4000;
        String sub;
        while (index < str.length()) {
            // java的字符不允许指定超过总的长度end
            if (str.length() <= index + maxLength) {
                sub = str.substring(index);
            } else {
                sub = str.substring(index, maxLength + index);
            }

            index += maxLength;
            Log.e(tag, sub.trim());
        }
    }

    public static void s(String content) {
        if(content != null) {
            s("Xposed", content);
        }
    }
}
