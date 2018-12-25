package cn.qianshu.tick.entity;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Ticket {

    @Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String activity_id;
 
	private String activity_descript;	
	private Integer ticket_total_num;	
	private Date end_time;	
	private Date start_time;
	private boolean is_end;// 0:活动中  1 :已结束
	private Integer left_num;
	public Ticket() {
		// TODO Auto-generated constructor stub
	}
	
	public String getActivity_id() {
		return activity_id;
	}
	public void setActivity_id(String activity_id) {
		this.activity_id = activity_id;
	}
	public String getActivity_descript() {
		return activity_descript;
	}
	public void setActivity_descript(String activity_descript) {
		this.activity_descript = activity_descript;
	}
	public Integer getTicket_total_num() {
		return ticket_total_num;
	}
	public void setTicket_total_num(Integer ticket_total_num) {
		this.ticket_total_num = ticket_total_num;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public boolean getIs_end() {
		return is_end;
	}
	public void setIs_end(boolean is_end) {
		this.is_end = is_end;
	}

	public Integer getLeft_num() {
		return left_num;
	}

	public void setLeft_num(Integer left_num) {
		this.left_num = left_num;
	}

}
