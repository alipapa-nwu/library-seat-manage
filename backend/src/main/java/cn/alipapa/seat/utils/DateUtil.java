package cn.alipapa.seat.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static Date setYMD(Date value, int year, int month, int date) {
        var calendar = Calendar.getInstance();
        calendar.setTime(value);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DATE, date);
        return calendar.getTime();
    }

    public static Date setCurrentYMD(Date value) {
        var calendar = Calendar.getInstance();
        return setYMD(value, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));
    }

    public static boolean inMealTime(Date value) {
        var calendar = Calendar.getInstance();
        calendar.setTime(value);
        var hour = calendar.get(Calendar.HOUR_OF_DAY);
        var min = calendar.get(Calendar.MINUTE);
        return ((hour >= 11 && min >= 30) && (hour < 13)) || ((hour >= 17 && min >= 30) && (hour < 19));
    }
}
