package cn.alipapa.seat.bean;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Record {
    private Integer id;
    private Integer user_id;
    @JsonFormat(pattern = "HH:mm", timezone = "GMT+8")
    private Date enter_time;

    @JsonFormat(pattern = "HH:mm", timezone = "GMT+8")
    private Date leave_time;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date record_date;

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

    public Date getRecord_date() {
        return record_date;
    }

    public void setRecord_date(Date record_date) {
        this.record_date = record_date;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Record{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", enter_time=" + enter_time +
                ", leave_time=" + leave_time +
                ", record_date=" + record_date +
                '}';
    }
}