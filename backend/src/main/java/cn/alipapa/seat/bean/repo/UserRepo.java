package cn.alipapa.seat.bean.repo;

import cn.alipapa.seat.bean.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "user", collectionResourceRel = "user")
public interface UserRepo extends JpaRepository<User, Integer> {

}
