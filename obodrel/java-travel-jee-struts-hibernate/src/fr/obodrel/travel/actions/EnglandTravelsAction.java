package fr.obodrel.travel.actions;

import java.util.Calendar;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class EnglandTravelsAction extends ActionSupport {
	
	public Date getTravelDate() {
		Calendar currCalendar = Calendar.getInstance();
		currCalendar.set(2017, 3, 27);
		return currCalendar.getTime();
	}
	
	public int getTravelPrice() {
		return 739;
	}
	
	public String execute() {
		return ActionSupport.SUCCESS;
	}

}
