package fr.ib.travel.england;


import java.util.Calendar;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class TravelsAction extends ActionSupport {
	
	int price = 739;
	
	public String execute() {
		return ActionSupport.SUCCESS;
		
	}
		
	public Date getDeparture(){
		Calendar c = Calendar.getInstance();
		c.set(2017, 3, 27);
		Date d = c.getTime();
		return d;
	 }
	public int getPrice(){				
		return price;
	}
	
	
}


