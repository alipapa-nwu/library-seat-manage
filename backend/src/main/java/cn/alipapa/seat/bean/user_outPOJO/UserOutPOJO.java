package cn.alipapa.seat.bean.user_outPOJO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class UserOutPOJO {
    @JsonFormat(pattern = "HH:mm")
    private Date leave_time;
    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date record_date;
    private Integer user_id;

    @Override
    public String toString() {
        return "UserOutPOJO{" +
                "leave_time=" + leave_time +
                ", id=" + id +
                ", record_date=" + record_date +
                ", user_id=" + user_id +
                '}';
    }

    public Date getLeave_time() {
        return leave_time;
    }

    public void setLeave_time(Date leave_time) {
        this.leave_time = leave_time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRecord_date() {
        return record_date;
    }

    public void setRecord_date(Date record_date) {
        this.record_date = record_date;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
