package cn.alipapa.seat.controller;

import cn.alipapa.seat.bean.user_outPOJO.UserOutPOJO;
import cn.alipapa.seat.service.SeatService;
import cn.alipapa.seat.service.UserOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
public class PublicController {
    @Autowired
    SeatService seatService;
    @Autowired
    UserOutService userOutService;

    @GetMapping("/public/get_remaining_seats")
    public Object getRemainingSeats() {
        return seatService.getRemainingSeatsOfEachLevel();
    }

    @PostMapping(path="/external/user_out")
    public Object userOutRecord(@RequestBody UserOutPOJO userOutPOJO) throws ParseException {
        userOutService.userOutRecord(userOutPOJO);
        return userOutPOJO;
    }
}
