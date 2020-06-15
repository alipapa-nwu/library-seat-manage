package cn.alipapa.seat.dao;

import cn.alipapa.seat.bean.sql.LevelCount;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatDao {
    List<LevelCount> getRemainingSeatsEachLevel();
}
