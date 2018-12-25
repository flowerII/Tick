package cn.qianshu.tick.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.qianshu.tick.entity.Order1;
import cn.qianshu.tick.repository.OrderRepository;

@Service
@Transactional
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public void save(Order1 o) {
		orderRepository.save(o);
		return ;
	}

	public Order1 get_by_id_and_ip(String ip_address, String activity_id) {
		return orderRepository.get_by_id_and_ip(ip_address,activity_id);
	}

	public Page<Order1> pageOrders(String activity_id,int startPage) {
		Sort sort = new Sort(Direction.ASC, "id");
		@SuppressWarnings("deprecation")
		Pageable pageable = new PageRequest(startPage,6,sort);
        return orderRepository.pageOrders(pageable,activity_id);
	}

}
