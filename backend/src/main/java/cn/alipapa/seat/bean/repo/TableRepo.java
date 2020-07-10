package cn.alipapa.seat.bean.repo;

import cn.alipapa.seat.bean.entity.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "table", collectionResourceRel = "table")
public interface TableRepo extends JpaRepository<Table, Integer> {

}
