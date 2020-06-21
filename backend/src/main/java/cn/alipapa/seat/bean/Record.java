package cn.alipapa.seat.bean;


import java.util.Date;

public class Record {
    private Date enter_time;
    private Date leave_time;
    private Integer id;
    private Date record_date;
    private String user_id;

    @Override
    public String toString() {
        return "Record{" +
                "enter_time=" + enter_time +
                ", leave_time=" + leave_time +
                ", id=" + id +
                ", record_date=" + record_date +
                ", user_id='" + user_id + '\'' +
                '}';
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

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
