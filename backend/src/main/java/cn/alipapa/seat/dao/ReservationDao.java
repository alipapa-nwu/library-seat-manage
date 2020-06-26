package cn.alipapa.seat.dao;

import cn.alipapa.seat.bean.entity.Reservation;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationDao {
    List<Reservation> getReservationOnSeatAtDate(int seatId, Date date);

    int updateEnterTime(int reservationId, Date enterTime);

    int updateLeaveTime(int reservationId, Date leaveTime);

    Reservation getProceedingReservationOfUser(int userId);
}
