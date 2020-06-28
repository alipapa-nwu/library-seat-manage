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

    public static boolean isValidReservationTime(Date value) {
        var calendar = Calendar.getInstance();
        calendar.setTime(value);
        var hour = calendar.get(Calendar.HOUR_OF_DAY);
        return hour >= 8 && hour < 22;
    }

    public static boolean stillInPunish(Date punishDate) {
        if (punishDate == null) {
            return false;
        }
        var punish_until = punishDate.getTime() + 7 * 24 * 60 * 60 * 1000;
        return new Date().getTime() < punish_until;
    }

    public static boolean canMakeTomorrowsReservation() {
        var calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 18);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.SECOND, 0);
        return new Date().getTime() < calendar.getTimeInMillis();
    }
}
