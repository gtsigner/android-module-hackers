package com.oeynet.hackers.plugin.utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;

/**
 * Created by ZengYinan.
 * Date: 2019/5/16 11:08
 * Email: 498338021@qq.com
 * Desc:
 */
public class DeviceUtils {
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getIMEI(Context context) {
        try {
            //实例化TelephonyManager对象
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            //获取IMEI号
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                return "";
            }
            String imei = telephonyManager.getImei();
            //在次做个验证，也不是什么时候都能获取到的啊
            if (imei == null) {
                imei = "";
            }
            return imei;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }
}
