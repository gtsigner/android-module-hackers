package com.oeynet.hackers.hook.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ZengYinan.
 * Date: 2019/5/17 15:58
 * Email: 498338021@qq.com
 * Desc:
 */
public class DateUtils {
    public static String getFirstOfMonth(String resultDateFormat)  {
        //获取当前月第一天：
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        String first = new SimpleDateFormat(resultDateFormat).format(c.getTime());

        return first;
    }

    public static String getLastOfMonth(String resultDateFormat) {
        //获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        String last = new SimpleDateFormat(resultDateFormat).format(ca.getTime());
        return last;
    }
}
