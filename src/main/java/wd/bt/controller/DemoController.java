package wd.bt.controller;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

	@Resource
	private DataSource dataSource;
	
	@RequestMapping("helloword")
	@ResponseBody
	public String helloWord() {
		System.out.println(dataSource);
		return "hello word!";
	}
	
	
}
