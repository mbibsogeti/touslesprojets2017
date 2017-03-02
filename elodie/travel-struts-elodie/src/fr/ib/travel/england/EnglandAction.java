package fr.ib.travel.england;

import java.util.Calendar;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class EnglandAction extends ActionSupport{
	
	
	
	public String execute() {
		return ActionSupport.SUCCESS;
	}
	
	public Date getDate(){
		Calendar c = Calendar.getInstance();
		c.set(2017, 3, 27);
		Date d = c.getTime();
		return d;
	}
	
	public int getPrix(){
		int prix = 739;
		return prix;
	}
}
