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
        var total = seatDao.getTotalSeatsEachLevel();
        var inUse = seatDao.getInUseSeatsEachLevel();
        for (var i : inUse) {
            for (var j : total) {
                if (i.getLevel().equals(j.getLevel())) {
                    j.setCount(j.getCount() - i.getCount());
                }
            }
        }
        return total;
    }

    public LevelSeatResponse getSeatInformationForEachFloor(int level, boolean today) {
				var date = new Date();
				// 如果是明天，加24小时
        if (!today) {
            date.setTime(date.getTime() + 24 * 60 * 60 * 1000);
				}
				// 获取指定楼层所有桌子
				var tables = tableDao.getTablesInFloor(level);
				// 创建响应结构，把每一个桌子对应的座位、每个座位当天的预约装入响应结构
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
				// 返回响应结构
        return response;
    }
}
