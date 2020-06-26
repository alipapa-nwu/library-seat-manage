package cn.alipapa.seat.controller;

import cn.alipapa.seat.bean.request.BindRequest;
import cn.alipapa.seat.service.BindSerialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrivateController {
    @Autowired
    BindSerialService bindSerialService;

    @PostMapping("/private/bind_serial")
    public Object BindSerial(@RequestBody BindRequest bindRequest) {
        return bindSerialService.bindSerial(bindRequest);
    }
}
