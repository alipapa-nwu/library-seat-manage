package cn.alipapa.seat.service;

import cn.alipapa.seat.bean.request.UserOutPOJO;
import cn.alipapa.seat.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public void userOutRecord(UserOutPOJO userOutPOJO) {
        userDao.postLeaveTime(userOutPOJO.getRecord_date(),
                userOutPOJO.getLeave_time(),
                userOutPOJO.getUser_id());
    }
}
