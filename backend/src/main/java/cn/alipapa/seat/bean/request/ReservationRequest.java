package cn.alipapa.seat.bean.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ReservationRequest {
    private Integer seat_id;
    private boolean today;

    @JsonFormat(pattern = "HH:mm", timezone = "GMT+8")
    private Date start;

    @JsonFormat(pattern = "HH:mm", timezone = "GMT+8")
    private Date end;

    @Override
    public String toString() {
        return "ReservationRequest{" +
                "seat_id=" + seat_id +
                ", today=" + today +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    public Integer getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(Integer seat_id) {
        this.seat_id = seat_id;
    }

    public boolean isToday() {
        return today;
    }

    public void setToday(boolean today) {
        this.today = today;
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
}
