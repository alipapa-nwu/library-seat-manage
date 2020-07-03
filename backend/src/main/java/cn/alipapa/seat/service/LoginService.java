package cn.alipapa.seat.service;


import cn.alipapa.seat.bean.request.LoginRequest;
import cn.alipapa.seat.bean.response.LoginResponse;
import cn.alipapa.seat.bean.response.WechatLoginResponse;
import cn.alipapa.seat.dao.UserDao;
import cn.alipapa.seat.exception.LoginException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class LoginService {
    @Autowired
    UserDao userDao;
    @Value("${appid}")
    String appID;
    @Value("${appsecret}")
    String appsecret;

    @Autowired
    HttpUtil httpUtil;

    private static final String URL = "https://api.weixin.qq.com/sns/jscode2session";

    public LoginResponse login(LoginRequest loginRequest) throws JsonProcessingException {
        // 用jscode换openid
        var wechatResponse = httpUtil.wechatLogin(loginRequestInit(loginRequest));
        // 用openid找user
        var user = userDao.getUserInformation(wechatResponse.getOpenid());
        // 没找到，插入一个
        if (user == null) {
            var result = userDao.insertAUser(wechatResponse.getOpenid());
            if (result == 0) {
                throw new LoginException("登陆失败：数据库异常");
            }
            user = userDao.getUserInformation(wechatResponse.getOpenid());
        }
        // 用openId加盐生成一个sessionId
        var sessionId = new SimpleHash("SHA-256", wechatResponse.getOpenid(),
                String.valueOf(Math.random()), 1024).toString();
        // 更新session info
        var result = userDao.updateSessionInfo(wechatResponse.getOpenid(), sessionId,
                wechatResponse.getSession_key());
        if (result == 0) {
            throw new LoginException("登陆失败：数据库异常");
        }
        return new LoginResponse(user.getSerial(),wechatResponse.getOpenid(), sessionId);
    }

    private HashMap<String, String> loginRequestInit(LoginRequest loginRequest) {
        HashMap<String, String> paraMap = new HashMap<>();
        paraMap.put("appid", appID);
        paraMap.put("secret", appsecret);
        paraMap.put("js_code", loginRequest.getCode());
        paraMap.put("grant_type", "authorization_code");
        System.out.println(paraMap);
        return paraMap;
    }//hashMap打包appid等数据

    private WechatLoginResponse httpRequest(HashMap<String, String> map) {
        RestTemplate request = new RestTemplate();
        WechatLoginResponse wechatLoginResponse;
        //向code2session接口发送请求
        wechatLoginResponse = request.getForObject(URL, WechatLoginResponse.class, map);
        if (wechatLoginResponse == null) {
            throw new LoginException("登陆失败：无法连接至微信服务器");
        }
        if(wechatLoginResponse.getOpenid()==null||wechatLoginResponse.getSession_key()==null){
            System.out.println(wechatLoginResponse);
            throw new LoginException("登陆失败：微信服务器返回结果异常");
        }
        switch (wechatLoginResponse.getErrcode()) {
            case 1:
                throw new LoginException("系统繁忙，稍后再试");
            case 40029:
                throw new LoginException("code无效");
            case 45011:
                throw new LoginException("访问过于频繁，请一分钟后再试");
        }
        //匹配错误代码
        return wechatLoginResponse;
    }

}