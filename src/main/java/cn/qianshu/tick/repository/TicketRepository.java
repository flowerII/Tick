package cn.qianshu.tick.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cn.qianshu.tick.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>,JpaSpecificationExecutor<Ticket> {

	List<Ticket> findAll();
	
	@Query("select t from Ticket t where t.is_end = 0")
	Page<Ticket> findByActive(Pageable pageable);

	@Query("select t from Ticket t where t.activity_id =:activity_id")
	Ticket findByActivityId(@Param("activity_id") String activity_id);
}
