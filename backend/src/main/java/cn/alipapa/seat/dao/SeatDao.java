package cn.alipapa.seat.dao;

import cn.alipapa.seat.bean.entity.Seat;
import cn.alipapa.seat.bean.response.LevelCountResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatDao {
    List<LevelCountResponse> getInUseSeatsEachLevel();

    List<LevelCountResponse> getTotalSeatsEachLevel();

    List<Seat> getSeatsOfTable(int tableId);

    Seat getSeat(int id);
}
