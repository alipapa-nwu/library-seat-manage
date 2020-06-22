package cn.alipapa.seat.controller;

import cn.alipapa.seat.bean.request.UserOutPOJO;
import cn.alipapa.seat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExternalController {
    @Autowired
    UserService userService;

    @PostMapping("/external/user_out")
    public Object userOutRecord(@RequestBody UserOutPOJO userOutPOJO) {
        userService.userOutRecord(userOutPOJO);
        return userOutPOJO;
    }
}
