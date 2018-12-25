package cn.qianshu.tick.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class indexController {

	private static Logger logger = LoggerFactory.getLogger(indexController.class);
	
	@RequestMapping("/testIP")
    public String index() {
        return "testIP";
    }
	
	@RequestMapping(value = "/getPage", method=RequestMethod.GET)
    public String getTickPage() {
        return "getPage";
    }
	
	@RequestMapping(value = "/getTick", method=RequestMethod.POST)
	@ResponseBody
    public String getTick(@RequestParam("ipAddress") String ipAddress,@RequestParam("activity_id") String activity_id) {
		logger.info(ipAddress);
		logger.info(activity_id);
        return "1";
    }
}
