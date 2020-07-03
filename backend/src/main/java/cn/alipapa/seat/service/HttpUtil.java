package cn.alipapa.seat.service;


import cn.alipapa.seat.bean.response.WechatLoginResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

@Component
public class HttpUtil{
    @Autowired
    private ObjectMapper mapper;

    public WechatLoginResponse wechatLogin(Map<String, String> params) throws JsonProcessingException {
        StringBuilder urlString = new StringBuilder("https://api.weixin.qq.com/sns/jscode2session?");
        for(var i : params.keySet()){
            urlString.append(i).append("=").append(params.get(i)).append("&");
        }
        urlString.deleteCharAt(urlString.length()-1);
        System.out.println(urlString.toString());
        HttpURLConnection connection = null;
        InputStream is = null;
        BufferedReader br = null;
        String result = null;
        try {
            URL url = new URL(urlString.toString());
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(60000);
            connection.connect();
            if (connection.getResponseCode() == 200) {
                is = connection.getInputStream();
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                StringBuffer sbf = new StringBuffer();
                String temp = null;
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            assert connection != null;
            connection.disconnect();
        }
        System.out.println(result);

        assert result != null;
        assert mapper != null;
        var res = mapper.readValue(result, WechatLoginResponse.class);
        return res;
    }
}