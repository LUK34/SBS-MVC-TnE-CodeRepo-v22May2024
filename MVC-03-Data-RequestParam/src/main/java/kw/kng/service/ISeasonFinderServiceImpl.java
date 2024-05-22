package kw.kng.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service("seasonService")
public class ISeasonFinderServiceImpl implements ISeasonFinderService
{

	@Override
	public String findSeason() 
	{
		//get System date
		LocalDate id = LocalDate.now();
		
		//get current month
		int month= id.getMonthValue();
		
		//Find season
		if(month >=7 && month<=9)
		{
			return "Autumn Season";
		}
		else if(month>=3 && month<=6)
		{
			return "Summer Season";
		}
		else
		{
			return "Winter Season";
		}
	
	}

}
