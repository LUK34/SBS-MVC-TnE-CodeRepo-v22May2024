package kw.kng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController 
{
	//@RequestMapping("/home")
	@RequestMapping("/")
	public String showHome()
	{
		//return Logical View Name
		return "welcome";
	}

}
