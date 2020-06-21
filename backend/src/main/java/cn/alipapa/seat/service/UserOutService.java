package cn.alipapa.seat.service;

import cn.alipapa.seat.bean.user_outPOJO.UserOutPOJO;
import cn.alipapa.seat.dao.UserOutDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;

@Service
public class UserOutService {
    @Autowired
    UserOutDao userOutDao;


    public void userOutRecord(@RequestBody UserOutPOJO userOutPOJO) throws ParseException {
        Date recordDate= new Date(userOutPOJO.getRecord_date().getTime());
        Time leaveTime= new Time(userOutPOJO.getLeave_time().getTime());
        userOutDao.postLeaveTime(recordDate,leaveTime, userOutPOJO.getUser_id());
    }
}
