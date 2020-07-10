package cn.alipapa.seat.bean.repo;

import cn.alipapa.seat.bean.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "seat", collectionResourceRel = "seat")
public interface SeatRepo extends JpaRepository<Seat, Integer> {

}
