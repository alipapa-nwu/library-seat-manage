package cn.alipapa.seat.bean.entity;


import java.util.Date;

public class Reservation {
    private Integer id;
    private Integer user_id;
    private Integer seat_id;
    private Date start;
    private Date end;
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
}