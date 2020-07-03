package cn.alipapa.seat.dao;

import cn.alipapa.seat.bean.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User getUserInformation(String openId);

    int insertAUser(String openId);

    int updateSessionInfo(String openId, String sessionId, String sessionKey);
}
