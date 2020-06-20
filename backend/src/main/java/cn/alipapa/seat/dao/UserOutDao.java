package cn.alipapa.seat.dao;

import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface UserOutDao {
   void postLeaveTime(Date leaveTime,int userId);
}
