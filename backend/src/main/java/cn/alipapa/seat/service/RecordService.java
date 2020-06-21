package cn.alipapa.seat.service;

import cn.alipapa.seat.bean.user_inPOJO.UserInPOJO;
import cn.alipapa.seat.dao.RecordDao;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class RecordService {
    @Autowired
    RecordDao recordDao;

    public void userIn(@RequestBody UserInPOJO userInPOJO) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Date enterTime = sdf1.parse(userInPOJO.getEnter_time());
        Date recordDate = sdf2.parse(userInPOJO.getRecord_date());
        //System.out.println(leaveTime);
        recordDao.userIn(userInPOJO.getUser_id(),enterTime,recordDate);
    }
}
