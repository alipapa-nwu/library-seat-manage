package cn.alipapa.seat.controller;

import cn.alipapa.seat.annotation.PrivateRequestHandler;
import cn.alipapa.seat.bean.entity.User;
import cn.alipapa.seat.bean.request.BindRequest;
import cn.alipapa.seat.service.BindSerialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PrivateController {
    @Autowired
    BindSerialService bindSerialService;

    @PostMapping("/private/bind_serial")
    @PrivateRequestHandler
    public Object bindSerial(@RequestHeader("open_id") String openId,
                             @RequestHeader("session_id") String sessionId,
                             User user,
                             @RequestBody BindRequest bindRequest) {
        return bindSerialService.bindSerial(bindRequest, user);
    }

    @GetMapping("/private/get_reservations")
    @PrivateRequestHandler
    public Object getReservations(@RequestHeader("open_id") String openId,
                                  @RequestHeader("session_id") String sessionId,
                                  User user,
                                  @RequestBody BindRequest bindRequest) {
        return bindSerialService.bindSerial(bindRequest, user);
    }
}
