package cn.alipapa.seat.service;

import cn.alipapa.seat.bean.response.BinaryStatusResponse;
import cn.alipapa.seat.dao.ReservationDao;
import cn.alipapa.seat.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReservationService {
    @Autowired
    ReservationDao reservationDao;

    public BinaryStatusResponse userIn(int userId) {
        var reservation = reservationDao.getProceedingReservationOfUser(userId);
        if (reservation == null) {
            // 没有找到预约
            throw new CustomException("用户进馆失败：不在预约时段内");
        } else if (reservation.getEnter_time() == null && reservation.getLeave_time() == null) {
            // 没有进馆/离馆记录，正常进馆
            var affectedLines = reservationDao.updateEnterTime(reservation.getId(), new Date());
            if (affectedLines == 0) {
                throw new CustomException("用户进馆失败：数据库异常");
            }
        } else if (reservation.getEnter_time() != null && reservation.getLeave_time() != null) {
            // 有进馆/离馆记录，若为暂离，离馆时间置空
            if (reservation.wasAway()) {
                reservationDao.updateLeaveTime(reservation.getId(), null);
            }
        } else {
            throw new CustomException("用户进馆失败：用户行为异常");
        }
        return new BinaryStatusResponse(true);
    }

    public BinaryStatusResponse userOutRecord(int userId) {
        var reservation = reservationDao.getProceedingReservationOfUser(userId);
        if (reservation == null) {
            throw new CustomException("用户离馆失败：不在预约时段内");
        } else if (reservation.getEnter_time() != null && reservation.getLeave_time() == null) {
            // 有进馆记录，没有离馆记录，正常离馆
            var affectedLines = reservationDao.updateLeaveTime(reservation.getId(), new Date());
            if (affectedLines == 0) {
                throw new CustomException("用户离馆失败：数据库异常");
            }
        } else {
            throw new CustomException("用户离馆失败：用户行为异常");
        }
        return new BinaryStatusResponse(true);
    }
}

