package cn.alipapa.seat.service;


import cn.alipapa.seat.bean.request.LoginRequest;
import cn.alipapa.seat.bean.response.OpenidRequestResponse;
import cn.alipapa.seat.bean.response.LoginStatusResponse;
import cn.alipapa.seat.dao.LoginDao;
import cn.alipapa.seat.exception.LoginRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class LoginService {
    @Autowired
    LoginDao loginDao;
    @Value("${appid}")
    String appID;
    @Value("${appsecret}")
    String appsecret;
    private static final String URL = "https://api.weixin.qq.com/sns/jscode2session";

    public LoginStatusResponse login(LoginRequest loginRequest) {
        OpenidRequestResponse loginInformationResponse = httpRequest(loginRequestInit(loginRequest));
        //获取一个请求返回体
        var userInformation = loginDao.getLoginInformation(loginInformationResponse);
        //利用获得的openid等信息调用DAO层进行查询，获得userInformation List对象
        if (userInformation.size() == 0) {
            throw new LoginRequestException("用户未绑定");
        }//List为空说明该openid未绑定学号，抛出异常
        return new LoginStatusResponse(true);
        //List非空，将状态置true，和学号一起发送给Controller
    }

    private HashMap<String, String> loginRequestInit(LoginRequest loginRequest) {
        HashMap<String, String> paraMap = new HashMap<String, String>();
        HashMap<String, String> requestResult = new HashMap<String, String>();
        paraMap.put("appid", appID);
        paraMap.put("secret", appsecret);
        paraMap.put("js_code", loginRequest.getCode());
        paraMap.put("grant_type", "authorization_code");
        return paraMap;
    }//hashMap打包appid等数据

    private OpenidRequestResponse httpRequest(HashMap<String, String> map) {
        RestTemplate request = new RestTemplate();
        OpenidRequestResponse loginInformationResponse;
        loginInformationResponse = request.getForObject(URL, OpenidRequestResponse.class, map);//向code2session接口发送请求
        switch (loginInformationResponse.getErrcode()) {
            case 1:
                throw new LoginRequestException("系统繁忙，稍后再试");
            case 40029:
                throw new LoginRequestException("code无效");
            case 45011:
                throw new LoginRequestException("访问过于频繁，请一分钟后再试");
        }
        //匹配错误代码
        return loginInformationResponse;
    }

}
