package cn.alipapa.seat.dao;

import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface RecordDao {
    int insertEnterTime(int userId, Date enterTime, Date recordDate);

    int updateLeaveTime(int userId, Date leaveTime, Date recordDate);
}
