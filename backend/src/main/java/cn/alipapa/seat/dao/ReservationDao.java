package cn.alipapa.seat.dao;

import cn.alipapa.seat.bean.entity.Reservation;
import cn.alipapa.seat.bean.entity.User;
import cn.alipapa.seat.bean.response.ReservationResponse;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationDao {
    List<Reservation> getReservationOnSeatAtDate(int seatId, Date date);

    int updateEnterTime(int reservationId, Date enterTime);

    int updateLeaveTime(int reservationId, Date leaveTime);

    Reservation getProceedingReservationOfUser(int userId);

    List<ReservationResponse> getReservations(int userId, int limit, int offset);

    Reservation getLatestReservationOfUser(Date date, int userId);

    int insertAReservation(int userId, int seatId, Date start, Date end, Date date);

    User getUseridBySerial(String serial);
}
