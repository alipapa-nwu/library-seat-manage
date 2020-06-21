package cn.alipapa.seat.controller;

import cn.alipapa.seat.bean.user_inPOJO.UserInPOJO;
import cn.alipapa.seat.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;


@RestController
public class ExternalController {
    @Autowired
    RecordService recordService;

    @PostMapping(path="/external/user_in")
    public Object userIn(@RequestBody UserInPOJO userInPOJO) throws ParseException {
        //System.out.println(userInPOJO);
        recordService.userIn(userInPOJO);
        return userInPOJO;
    }
}
