package com.oeynet.hackers.hook.utils;

import de.robv.android.xposed.XposedBridge;

/**
 * Created by ZengYinan.
 * Date: 2019/3/17 14:52
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
            XposedBridge.log(tag+"================="+sub.trim());
        }
    }

    public static void s(String content) {
        s("Xposed", content);
    }
}
