package com.course.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TabController {
	
	@RequestMapping("/")
	public String getTabPage() {
		return "tab";
	}

}
