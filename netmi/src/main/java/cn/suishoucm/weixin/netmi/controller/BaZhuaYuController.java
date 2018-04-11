package cn.suishoucm.weixin.netmi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaZhuaYuController {
	

	@RequestMapping("edit123")
	public String edit123(){
		
		return "baZhuaYu/baZhuaYuHome";
	}
}
