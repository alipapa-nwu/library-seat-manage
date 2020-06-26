package cn.alipapa.seat.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface BindDao {
    String getPassword(String serial);
    int getBindStatus(String serial);
    int bindOpenid(String openid,String session_key,String serial);
}
