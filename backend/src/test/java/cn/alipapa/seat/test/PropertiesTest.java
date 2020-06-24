package cn.alipapa.seat.test;

import cn.alipapa.seat.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = {Application.class})
@RunWith(SpringRunner.class)
public class PropertiesTest {
    @Value("${appid}")
    String appId;

    @Value("${appsecret}")
    String appSecret;

    @Test
    public void getMiniProgramConfig() {
        System.out.println(appId);
        System.out.println(appSecret);
    }
}
