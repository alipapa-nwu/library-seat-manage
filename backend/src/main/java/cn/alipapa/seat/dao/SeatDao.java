package cn.alipapa.seat.dao;

import cn.alipapa.seat.bean.response.LevelCountResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatDao {
    List<LevelCountResponse> getRemainingSeatsEachLevel();
}
