package cn.alipapa.seat.service;

import cn.alipapa.seat.bean.entity.Reservation;
import cn.alipapa.seat.bean.entity.User;
import cn.alipapa.seat.bean.request.BindRequest;
import cn.alipapa.seat.bean.response.BinaryStatusResponse;
import cn.alipapa.seat.dao.ReservationDao;
import cn.alipapa.seat.dao.SerialDao;
import cn.alipapa.seat.exception.AccessDeniedException;
import cn.alipapa.seat.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    SerialDao serialDao;

    @Autowired
    ReservationDao reservationDao;

    public BinaryStatusResponse bindSerial(BindRequest bindRequest, User user) {
        if (user.getSerial() != null) {
            throw new CustomException("绑定失败：不能重复绑定");
        }
        if (!(serialDao.getPassword(bindRequest.getSerial()).equals(bindRequest.getPassword()))) {
            throw new AccessDeniedException("绑定失败：学号与身份证后六位不匹配");
        }
        if (serialDao.bindSerial(user.getOpenid(), bindRequest.getSerial()) != 1) {
            throw new AccessDeniedException("绑定失败：数据库异常");
        }
        return new BinaryStatusResponse(true);
    }

    public List<Reservation> getReservations(User user, int page) {
        return reservationDao.getReservations(user.getId(), 10, page * 10);
    }
}
