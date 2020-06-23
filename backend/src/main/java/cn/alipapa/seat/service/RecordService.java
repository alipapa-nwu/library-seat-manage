package cn.alipapa.seat.service;

import cn.alipapa.seat.bean.request.UserInOutRequest;
import cn.alipapa.seat.bean.response.BinaryStatusResponse;
import cn.alipapa.seat.dao.RecordDao;
import cn.alipapa.seat.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RecordService {
    @Autowired
    RecordDao recordDao;

    public BinaryStatusResponse userIn(UserInOutRequest userInOutRequest) {
        var res = recordDao.insertEnterTime(userInOutRequest.getUser_id(), userInOutRequest.getEnter_time(),
                userInOutRequest.getRecord_date());
        if (res != 1) {
            throw new CustomException("用户进馆失败：数据库异常");
        }
        return new BinaryStatusResponse(true);
    }

    public BinaryStatusResponse userOutRecord(UserInOutRequest userInOutRequest) {
        var res = recordDao.updateLeaveTime(userInOutRequest.getUser_id(), userInOutRequest.getLeave_time(),
                userInOutRequest.getRecord_date());
        if (res != 1) {
            throw new CustomException("用户离馆失败：数据库异常");
        }
        return new BinaryStatusResponse(true);
    }
}
