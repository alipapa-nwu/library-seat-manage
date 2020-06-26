package cn.alipapa.seat.controller;

import cn.alipapa.seat.bean.request.LoginRequest;
import cn.alipapa.seat.service.LoginService;
import cn.alipapa.seat.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {
    @Autowired
    SeatService seatService;
    @Autowired
    LoginService loginService;

    @GetMapping("/public/get_remaining_seats")
    public Object getRemainingSeats() {
        return seatService.getRemainingSeatsOfEachLevel();
    }

    @PostMapping("/public/login")
    public Object userLogin(@RequestBody LoginRequest loginRequest){
        return loginService.login(loginRequest);
    }
  
    @GetMapping("/public/get_level_seats")
    public Object getSeatInformationForEachFloor(@RequestParam("level") int level,
                                                 @RequestParam("today") boolean today) {
        return seatService.getSeatInformationForEachFloor(level, today);
    }
}
