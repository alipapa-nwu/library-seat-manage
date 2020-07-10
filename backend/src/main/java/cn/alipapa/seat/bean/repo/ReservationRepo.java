package cn.alipapa.seat.bean.repo;

import cn.alipapa.seat.bean.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "reservation", collectionResourceRel = "reservation")
public interface ReservationRepo extends JpaRepository<Reservation, Integer> {

}
