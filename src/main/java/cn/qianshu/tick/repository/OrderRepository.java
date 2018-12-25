package cn.qianshu.tick.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cn.qianshu.tick.entity.Order1;

@Repository
public interface OrderRepository extends JpaRepository<Order1, Integer>,JpaSpecificationExecutor<Order1> {

	@Query("select o from Order1 o where o.ip_address =:ip_address and o.activity_id =:activity_id")
	Order1 get_by_id_and_ip(@Param("ip_address")String ip_address,@Param("activity_id")String activity_id);

	@Query("select o from Order1 o where o.activity_id =:activity_id")
	Page<Order1> pageOrders(Pageable pageable,@Param("activity_id")String activity_id);

}
