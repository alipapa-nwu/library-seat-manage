package cn.alipapa.seat.bean.entity;

import java.util.Calendar;
import java.util.Date;

public class Reservation {
    private Integer id;
    private Integer user_id;
    private Integer seat_id;
    private Date start;
    private Date end;
    private Date enter_time;
    private Date leave_time;
    private Date reservation_date;

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", seat_id=" + seat_id +
                ", start=" + start +
                ", end=" + end +
                ", reservation_date=" + reservation_date +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(Integer seat_id) {
        this.seat_id = seat_id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Date getReservation_date() {
        return reservation_date;
    }

    public void setReservation_date(Date reservation_date) {
        this.reservation_date = reservation_date;
    }

    public Date getEnter_time() {
        return enter_time;
    }

    public void setEnter_time(Date enter_time) {
        this.enter_time = enter_time;
    }

    public Date getLeave_time() {
        return leave_time;
    }

    public void setLeave_time(Date leave_time) {
        this.leave_time = leave_time;
    }

    public boolean wasLate() {
        return enter_time.getTime() - DateUtil.setCurrentYMD(start).getTime() > (30 * 60 * 1000);
    }

    public boolean wasAway() {
        var maxAwayTime = 30 * 60 * 1000;
        var currentLeaveTime = DateUtil.setCurrentYMD(leave_time);
        if (DateUtil.inMealTime(currentLeaveTime)) {
            maxAwayTime *= 2;
        }
        return new Date().getTime() - currentLeaveTime.getTime() <= maxAwayTime;
    }
}

class DateUtil {
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