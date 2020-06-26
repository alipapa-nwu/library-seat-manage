package cn.alipapa.seat.service;

import cn.alipapa.seat.bean.response.LevelCountResponse;
import cn.alipapa.seat.bean.response.LevelSeatResponse;
import cn.alipapa.seat.dao.ReservationDao;
import cn.alipapa.seat.dao.SeatDao;
import cn.alipapa.seat.dao.TableDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SeatService {
    @Autowired
    SeatDao seatDao;
    @Autowired
    TableDao tableDao;
    @Autowired
    ReservationDao reservationDao;

    public List<LevelCountResponse> getRemainingSeatsOfEachLevel() {
        return seatDao.getRemainingSeatsEachLevel();
    }

    public LevelSeatResponse getSeatInformationForEachFloor(int level, boolean today) {
        var date = new Date();
        if (!today) {
            date.setTime(date.getTime() + 24 * 60 * 60 * 1000);
        }
        var tables = tableDao.getTablesInFloor(level);
        var response = new LevelSeatResponse();
        for (var table : tables) {
            var tableResponse = new LevelSeatResponse.TableResponse(table);
            var seats = seatDao.getSeatsOfTable(table.getId());
            for (var seat : seats) {
                var seatResponse = new LevelSeatResponse.SeatResponse(seat);
                seatResponse.setReservations(reservationDao.getReservationOnSeatAtDate(seat.getId(), date));
                tableResponse.getSeats().add(seatResponse);
            }
            response.getTables().add(tableResponse);
        }
        return response;
    }
}
