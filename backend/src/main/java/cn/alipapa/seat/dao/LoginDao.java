package cn.alipapa.seat.dao;

import cn.alipapa.seat.bean.response.OpenidRequestResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginDao {
    List<OpenidRequestResponse> getLoginInformation(OpenidRequestResponse loginInformationResponse);
}
