package cn.alipapa.seat.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface SerialDao {
    String getPassword(String serial);

    int bindSerial(String openid, String serial);
}
