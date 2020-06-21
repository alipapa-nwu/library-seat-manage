package cn.alipapa.seat.dao;

import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Time;

@Repository
public interface UserOutDao {
    void postLeaveTime(Date recordDate, Time leaveTime, int userId);
}
