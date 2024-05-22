package kw.kng.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kw.kng.service.ISeasonFinderService;

@Controller
public class SeasonOpController 
{
	@Autowired
	private ISeasonFinderService seasonService;
	
	@RequestMapping("/season")
	public String findSeason()
	{
		return "season";
	}
	
	@RequestMapping("/showSeason")
	public String showSeason(Map<String, Object>  map)
	{
		String msg= seasonService.findSeason();
		System.out.println("Season value: "+ msg);
		map.put("resultMsg", msg);
		
		return "show_season";
	}
	
	
	

}
