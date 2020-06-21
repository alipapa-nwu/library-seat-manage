package cn.alipapa.seat.bean.user_inPOJO;

import java.util.Date;

public class UserInPOJO {
    private String enter_time;
    private String leave_time;
    private Integer id;
    private String record_date;
    private Integer user_id;

    @Override
    public String toString() {
        return "UserOutPOJO{" +
                "enter_time='" + enter_time + '\'' +
                ", leave_time='" + leave_time + '\'' +
                ", id=" + id +
                ", record_date='" + record_date + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }

    public String getEnter_time() {
        return enter_time;
    }

    public void setEnter_time(String enter_time) {
        this.enter_time = enter_time;
    }

    public String getLeave_time() {
        return leave_time;
    }

    public void setLeave_time(String leave_time) {
        this.leave_time = leave_time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecord_date() {
        return record_date;
    }

    public void setRecord_date(String record_date) {
        this.record_date = record_date;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}