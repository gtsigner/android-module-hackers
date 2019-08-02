package com.oeynet.hackers.hook.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TimeUtils
 * 
 * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2013-8-24
 */
public class TimeUtils {

    public static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat DATE_FORMAT_DATE    = new SimpleDateFormat("yyyy-MM-dd");

    private TimeUtils() {
        throw new AssertionError();
    }

    /**
     * long time to string
     * 
     * @param timeInMillis timeInMillis
     * @param dateFormat   dateFormat
     * @return String
     */
    public static String getTime(long timeInMillis, SimpleDateFormat dateFormat) {
        return dateFormat.format(new Date(timeInMillis));
    }

    /**
     * long time to string, format is {@link #DEFAULT_DATE_FORMAT}
     * 
     * @param timeInMillis time
     * @return String
     */
    public static String getTime(long timeInMillis) {
        return getTime(timeInMillis, DEFAULT_DATE_FORMAT);
    }

    /**
     * get current time in milliseconds
     * 
     * @return long
     */
    public static long getCurrentTimeInLong() {
        return System.currentTimeMillis();
    }

    /**
     * get current time in milliseconds, format is {@link #DEFAULT_DATE_FORMAT}
     * 
     * @return  String
     */
    public static String getCurrentTimeInString() {
        return getTime(getCurrentTimeInLong());
    }

    /**
     * get current time in milliseconds
     * 
     * @param dateFormat    dateFormat
     * @return  String
     */
    public static String getCurrentTimeInString(SimpleDateFormat dateFormat) {
        return getTime(getCurrentTimeInLong(), dateFormat);
    }
    
    /**
     * 将给定的String类型的日期转换为指定格式
     * @param time
     * @return
     */
    public static String getFormatDate(String time, SimpleDateFormat oldDateFormat, SimpleDateFormat newDateFormat){
    	try {
			Date date = oldDateFormat.parse(time);
			return getTime(date.getTime(), newDateFormat);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    	
    }

    /**
     * 获取指定时间的时间戳
     * @return
     */
    public static long getTime(String user_time){
        long time = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d;
        try {
            d = sdf.parse(user_time);
            time = d.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    /**
     * 根据时分 得到时间戳
     * @param user_time
     * @return
     */
    public static long getTimeByTimestemp(String user_time){
        long time = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date d;
        try {
            d = sdf.parse(user_time);
            time = d.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    /**
     * 根据时间戳获取 时分
     * @param timeStemp
     * @return
     */
    public static String getTimeStempByTime(long timeStemp){
        return getTime(timeStemp, new SimpleDateFormat("HH:mm"));
    }


    /**
     * 获取两个字符串时间之间的相隔秒数
     * @param time1
     * @param time2
     * @return
     */
    public static long getInterval(String time1, String time2){
        return Math.abs(getTime(time1) - getTime(time2));
    }
}
