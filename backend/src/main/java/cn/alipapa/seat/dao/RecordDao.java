package cn.alipapa.seat.dao;

import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface RecordDao {
     void userIn(int user_id,  Date enterTime, Date recordDate);
}
