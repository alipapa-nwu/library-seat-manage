package cn.alipapa.seat.service;

import cn.alipapa.seat.bean.response.LevelCount;
import cn.alipapa.seat.dao.SeatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {
    @Autowired
    SeatDao seatDao;

    public List<LevelCount> getRemainingSeatsOfEachLevel() {
        return seatDao.getRemainingSeatsEachLevel();
    }
}
