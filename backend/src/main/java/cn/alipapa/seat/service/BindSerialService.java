package cn.alipapa.seat.service;

import cn.alipapa.seat.bean.request.BindRequest;
import cn.alipapa.seat.bean.response.BindStatusResponse;
import cn.alipapa.seat.bean.response.OpenidRequestResponse;
import cn.alipapa.seat.dao.BindDao;
import cn.alipapa.seat.exception.BindException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class BindSerialService {
    @Autowired
    BindDao bindDao;
    @Value("${appid}")
    String appID;
    @Value("${appsecret}")
    String appsecret;
    private static final String URL = "https://api.weixin.qq.com/sns/jscode2session";

    public BindStatusResponse bindSerial(BindRequest bindRequest) {
        if (!(bindDao.getPassword(bindRequest.getSerial()).equals(bindRequest.getPassword()))) {
            throw new BindException("密码与账号不匹配");
        }
        if (bindDao.getBindStatus(bindRequest.getSerial()) != 0) {
            throw new BindException("不能重复绑定");
        }
        OpenidRequestResponse openidRequestResponse = httpRequest(openidRequestInit(bindRequest));
        if (bindDao.bindOpenid(openidRequestResponse.getOpenid(),openidRequestResponse.getSession_key(),bindRequest.getSerial()) != 1) {
            throw new BindException("绑定失败");
        }
        return new BindStatusResponse(true);
    }

    private HashMap<String, String> openidRequestInit(BindRequest bindRequest) {
        HashMap<String, String> paraMap = new HashMap<String, String>();
        HashMap<String, String> requestResult = new HashMap<String, String>();
        paraMap.put("appid", appID);
        paraMap.put("secret", appsecret);
        paraMap.put("js_code", bindRequest.getJs_code());
        paraMap.put("grant_type", "authorization_code");
        return paraMap;
    }//hashMap打包appid等数据

    private OpenidRequestResponse httpRequest(HashMap<String, String> map) {
        RestTemplate request = new RestTemplate();
        OpenidRequestResponse openidRequestResponse;
        openidRequestResponse = request.getForObject(URL, OpenidRequestResponse.class, map);//向code2session接口发送请求
        switch (openidRequestResponse.getErrcode()) {
            case 1:
                throw new BindException("系统繁忙，稍后再试");
            case 40029:
                throw new BindException("code无效");
            case 45011:
                throw new BindException("访问过于频繁，请一分钟后再试");
        }
        //匹配错误代码
        return openidRequestResponse;
    }
}
