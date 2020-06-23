package cn.alipapa.seat.dao;

import cn.alipapa.seat.bean.response.LevelCountResponse;
import cn.alipapa.seat.bean.response.LevelSeatResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatDao {
    List<LevelCountResponse> getRemainingSeatsEachLevel();

    List<LevelSeatResponse> getSeatInformationForEachFloor(int level);
}
