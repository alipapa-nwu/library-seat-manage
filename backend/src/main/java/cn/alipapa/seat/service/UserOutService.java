package cn.alipapa.seat.service;

import cn.alipapa.seat.bean.user_outPOJO.UserOutPOJO;
import cn.alipapa.seat.dao.UserOutDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserOutService {
    @Autowired
    UserOutDao userOutDao;


    public void userOutRecord(@RequestBody UserOutPOJO userOutPOJO) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date leaveTime = sdf.parse(userOutPOJO.getLeave_time());
        System.out.println(leaveTime);
        userOutDao.postLeaveTime(leaveTime,userOutPOJO.getUser_id());
    }
}
