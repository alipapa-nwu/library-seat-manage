package cn.alipapa.seat.service;

import cn.alipapa.seat.bean.entity.User;
import cn.alipapa.seat.bean.request.BindRequest;
import cn.alipapa.seat.bean.response.BinaryStatusResponse;
import cn.alipapa.seat.bean.response.ReservationResponse;
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
				// 如果用户的学号不为空，则已经绑定过了，抛出异常
        if (user.getSerial() != null) {
            throw new CustomException("绑定失败：不能重复绑定");
				}
				// 如果用户给的学号和数据库中不匹配，返回403
        if (!(serialDao.getPassword(bindRequest.getSerial()).equals(bindRequest.getPassword()))) {
            throw new AccessDeniedException("绑定失败：学号与身份证后六位不匹配");
				}
				// 设置用户的serial字段，完成绑定
        if (serialDao.bindSerial(user.getOpenid(), bindRequest.getSerial()) != 1) {
            throw new AccessDeniedException("绑定失败：数据库异常");
        }
        return new BinaryStatusResponse(true);
    }

    public List<ReservationResponse> getReservations(User user, int page) {
        return reservationDao.getReservations(user.getId(), 10, page * 10);
    }
}
