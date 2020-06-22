package cn.alipapa.seat.dao;

import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface UserDao {
    void postLeaveTime(Date recordDate, Date leaveTime, int userId);
}
