package cn.qianshu.tick.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.qianshu.tick.entity.Order1;
import cn.qianshu.tick.entity.Ticket;
import cn.qianshu.tick.service.OrderService;
import cn.qianshu.tick.service.TicketService;
import cn.qianshu.tick.util.UUIDTool;

@Controller
public class ticketController {
	
	private static Logger logger = LoggerFactory.getLogger(ticketController.class);
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/index", method=RequestMethod.GET)
    public String getAcitivity(Model model) {
		Page<Ticket> ticketList=ticketService.pageTicket(0);
		model.addAttribute("ticketList", ticketList);
		logger.info("get activity list !!!");
        return "getPage";
    }
	
	@RequestMapping(value = "/getTotal", method=RequestMethod.GET)
    public String getTotal(Model model) {
		List<Ticket> ticketList=ticketService.allTicket();
		model.addAttribute("ticketList", ticketList);
		logger.info("get activity list !!!");
        return "total";
    }
	
	@RequestMapping(value = "/addTicket1", method=RequestMethod.GET)
	@ResponseBody
    public String getTicket(@RequestParam("activity_descript") String activity_descript,@RequestParam("ticket_total_num") Integer ticket_total_num,@RequestParam("start_time") String start_time) throws ParseException {
		Ticket t=new Ticket();
		t.setActivity_id(UUIDTool.getUUID());
		t.setActivity_descript(activity_descript);
		t.setTicket_total_num(ticket_total_num);
		t.setLeft_num(ticket_total_num);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(start_time);
		t.setStart_time(date);
		t.setIs_end(false);
		ticketService.save(t);
		logger.info("add ticket success");
        return "1";
    }
	
	@RequestMapping(value = "/addTicket", method=RequestMethod.GET)
    public String getTicketPage() {		
        return "add_ticket";
    }
	
	@RequestMapping(value = "/getActive", method=RequestMethod.GET)
    public String getTick(@RequestParam("activity_id") String activity_id,Model model) {
		Ticket t=ticketService.get_by_id(activity_id);
		model.addAttribute("t", t);
		logger.info("get_acitivty by id !!");
        return "detail1";
    }
	
	@RequestMapping(value = "/getAct", method=RequestMethod.GET)
	@ResponseBody
    public String getTick(Order1 o) {

		Ticket t=ticketService.get_by_id(o.getActivity_id());
		if(new Date().compareTo(t.getStart_time())<0) {
			return "活动尚未开始！！";
		}
		if(t.getLeft_num()==0) {
			return "已被抢完！！";
		}
		
		if(orderService.get_by_id_and_ip(o.getIp_address(),o.getActivity_id())!=null) {
			return "你已经使用本ip地址抢过了,不能再抢！";
		}
		
		o.setOrder_id(UUIDTool.getUUID());
		o.setOrder_time(new Date());
		orderService.save(o);
		
		t.setLeft_num(t.getLeft_num()-1);
		if(t.getLeft_num()==0) {
			t.setIs_end(true);
		}
		ticketService.save(t);
        return "1";
    }
	
	//登录
	@RequestMapping(value = "/login", method=RequestMethod.GET)
    public String login_get() {	
		logger.info("login brfore");
        return "login";
    }
	
	//登录后台显示
	@RequestMapping(value = "/admin", method=RequestMethod.GET)
    public String login_admin(Model model) {
		List<Ticket> ticketList=ticketService.allTicket();
		model.addAttribute("ticketList", ticketList);
		logger.info("login admin");
        return "admin";
    }
	
	@RequestMapping(value = "/getDetail", method=RequestMethod.GET)
    public String getDetail(@RequestParam("activity_id") String activity_id,Model model) {
        logger.info(activity_id);
		Ticket t=ticketService.get_by_id(activity_id);
		Page<Order1> orderList=orderService.pageOrders(activity_id,0);
		model.addAttribute("orderList", orderList);
		model.addAttribute("t", t);
        return "detail";
    }
}
