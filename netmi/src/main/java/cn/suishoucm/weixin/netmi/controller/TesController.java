package cn.suishoucm.weixin.netmi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TesController {
	Logger logger=LoggerFactory.getLogger(TesController.class);
	@RequestMapping("test")
	@ResponseBody
	public Object test() {
		try {
			int i=1/0;
		} catch (Exception e) {
			logger.error("", e);
		}
		
		return "ok";
	}

}
