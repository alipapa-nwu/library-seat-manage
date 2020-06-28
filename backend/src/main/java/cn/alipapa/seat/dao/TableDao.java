package cn.alipapa.seat.dao;

import cn.alipapa.seat.bean.entity.Table;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableDao {
    List<Table> getTablesInFloor(int level);
}
