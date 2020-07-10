package cn.alipapa.seat.bean.repo;

import cn.alipapa.seat.bean.entity.Serial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "serial", collectionResourceRel = "serial")
public interface SerialRepo extends JpaRepository<Serial, Integer> {

}
