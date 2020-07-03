package cn.alipapa.seat.bean.entity;

import java.util.Date;

public class User {
    private Integer id;
    private String serial;
    private String openid;
    private String session_id;
    private String session_key;
    private Date punish_date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public Date getPunish_date() {
        return punish_date;
    }

    public void setPunish_date(Date punish_date) {
        this.punish_date = punish_date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", serial='" + serial + '\'' +
                ", openid='" + openid + '\'' +
                ", session_id='" + session_id + '\'' +
                ", session_key='" + session_key + '\'' +
                ", punish_date=" + punish_date +
                '}';
    }
}