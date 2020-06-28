package cn.alipapa.seat.bean.response;

import java.util.Date;

public class ReservationResponse {
    private Integer id;
    private Integer user_id;
    private Integer seat_id;
    private Date start;
    private Date end;
    private Date enter_time;
    private Date leave_time;
    private Date reservation_date;
    private Integer level;
    private Integer column;
    private Integer row;
    private Integer position;

    @Override
    public String toString() {
        return "ReservationResponse{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", seat_id=" + seat_id +
                ", start=" + start +
                ", end=" + end +
                ", enter_time=" + enter_time +
                ", leave_time=" + leave_time +
                ", reservation_date=" + reservation_date +
                ", level=" + level +
                ", column=" + column +
                ", row=" + row +
                ", position=" + position +
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

    public Date getReservation_date() {
        return reservation_date;
    }

    public void setReservation_date(Date reservation_date) {
        this.reservation_date = reservation_date;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
