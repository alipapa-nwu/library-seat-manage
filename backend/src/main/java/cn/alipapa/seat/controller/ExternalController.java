package cn.alipapa.seat.controller;

import cn.alipapa.seat.bean.request.UserInOutRequest;
import cn.alipapa.seat.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExternalController {
    @Autowired
    ReservationService reservationService;

    @PostMapping(path = "/external/user_in")
    public Object userIn(@RequestBody UserInOutRequest userInOutRequest) {
        return reservationService.userIn(userInOutRequest.getSerial());
    }

    @PostMapping("/external/user_out")
    public Object userOutRecord(@RequestBody UserInOutRequest userInOutRequest) {
        return reservationService.userOutRecord(userInOutRequest.getSerial());
    }
}
