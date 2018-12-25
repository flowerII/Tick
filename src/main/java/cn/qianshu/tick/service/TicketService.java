package cn.qianshu.tick.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.qianshu.tick.entity.Ticket;
import cn.qianshu.tick.repository.TicketRepository;

@Service
@Transactional
public class TicketService {

	@Autowired
	private TicketRepository ticketRepository;
	
	//分类分页获取列表
	public Page<Ticket> pageTicket(int startPage){
		
		//Sort sort = new Sort("activity_id");
		@SuppressWarnings("deprecation")
		Pageable pageable = new PageRequest(startPage,6);
        return ticketRepository.findByActive(pageable);
	}
	
	public List<Ticket> allTicket(){
        return ticketRepository.findAll();
	}
	
	public void save(Ticket t) {
		ticketRepository.save(t);
		return ;
	}
	
	public Ticket get_by_id(String activity_id) {
		return ticketRepository.findByActivityId(activity_id);
	}

}
