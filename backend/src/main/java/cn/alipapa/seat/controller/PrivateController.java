package cn.alipapa.seat.controller;

import cn.alipapa.seat.annotation.PrivateRequestHandler;
import cn.alipapa.seat.bean.entity.User;
import cn.alipapa.seat.bean.request.BindRequest;
import cn.alipapa.seat.service.BindSerialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrivateController {
    @Autowired
    BindSerialService bindSerialService;

    @PostMapping("/private/bind_serial")
    @PrivateRequestHandler
    public Object bindSerial(@RequestBody BindRequest bindRequest,
                             @RequestHeader("open_id") String openId,
                             @RequestHeader("session_id") String sessionId,
                             User user) {
        return bindSerialService.bindSerial(bindRequest, user);
    }
}
