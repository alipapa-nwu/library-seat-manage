package cn.alipapa.seat.service;

import cn.alipapa.seat.bean.entity.User;
import cn.alipapa.seat.bean.request.ReservationRequest;
import cn.alipapa.seat.bean.response.BinaryStatusResponse;
import cn.alipapa.seat.dao.ReservationDao;
import cn.alipapa.seat.dao.SeatDao;
import cn.alipapa.seat.exception.CustomException;
import cn.alipapa.seat.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReservationService {
    @Autowired
    ReservationDao reservationDao;

    @Autowired
    SeatDao seatDao;

    @Autowired
    UserService userService;

    public BinaryStatusResponse userIn(String serial) {
        var userIdEntity = reservationDao.getUseridBySerial(serial);//通过serial获取对应的userid
        if (userIdEntity == null) {
            throw new CustomException("用户进馆失败：该用户未在本系统注册");
        }
        int userId=userIdEntity.getId();
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

    public BinaryStatusResponse userOutRecord(String serial) {
        var userIdEntity = reservationDao.getUseridBySerial(serial);//通过serial获取对应的userid
        if (userIdEntity == null) {
            throw new CustomException("用户进馆失败：该用户未在本系统注册");
        }
        int userId=userIdEntity.getId();
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

    public boolean haveProceedingReservationFor(boolean today, int userId) {
        var date = new Date();
        if (!today) {
            date = new Date(date.getTime() + 24 * 60 * 60 * 1000);
        }
        var reservation = reservationDao.getLatestReservationOfUser(date, userId);
        if (reservation == null) {
            return false;
        } else if (today) {
            var currentEndTime = DateUtil.setCurrentYMD(reservation.getEnd());
            return new Date().getTime() < currentEndTime.getTime();
        } else {
            return true;
        }
    }

    public BinaryStatusResponse requestReservation(ReservationRequest request, User user) {
        // 找出请求的座位，未找到即报错
        var seat = seatDao.getSeat(request.getSeat_id());
        if (seat == null) {
            throw new CustomException("预约失败：未找到座位");
        }
        // 如果预约时间不在一个图书馆日内，或结束大于开始，则报错
        if (!DateUtil.isValidReservationTime(request.getStart())
                || !DateUtil.isValidReservationTime(request.getStart())
                || !(request.getEnd().getTime() - request.getStart().getTime() > 0)) {
            throw new CustomException("预约失败：非法预约时间");
        }
        // 如果用户尚在惩罚期，报错
        var punishDate = user.getPunish_date();
        if (DateUtil.stillInPunish(punishDate)) {
            throw new CustomException("预约失败：用户尚在惩罚期");
        }
        // 若果已有预约正在进行或者明天有预约则报错
        if (haveProceedingReservationFor(request.isToday(), user.getId())) {
            throw new CustomException("预约失败：当天已有预约或预约正在进行");
        }
        // 如果是18:30之前预约第二天座位则报错
        var date = new Date();
        if (!request.isToday()) {
            if (!DateUtil.canMakeTomorrowsReservation()) {
                throw new CustomException("预约失败：此时不能预约明天的座位");
            }
            date = new Date(date.getTime() + 24 * 60 * 60 * 1000);
        }
        // 向数据库插入预约记录，完成预约
        var res = reservationDao.insertAReservation(user.getId(), request.getSeat_id(), request.getStart(),
                request.getEnd(), date);
        if (res != 1) {
            throw new CustomException("预约失败：数据库异常");
        }
        return new BinaryStatusResponse(true);
    }
}

