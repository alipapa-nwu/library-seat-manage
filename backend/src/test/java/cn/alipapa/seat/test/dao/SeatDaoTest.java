package cn.alipapa.seat.test.dao;

import cn.alipapa.seat.Application;
import cn.alipapa.seat.dao.SeatDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = {Application.class})
@RunWith(SpringRunner.class)
public class SeatDaoTest {
    @Autowired
    SeatDao seatDao;

    @Test
    public void getSeatsCountEachLevel() {
        var result = seatDao.getInUseSeatsEachLevel();
        assert result != null;
        System.out.println(result);
    }
}
