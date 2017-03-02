package fr.ib.hugo.travel.england;

import java.util.Calendar;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class EnglandInfo extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public String execute() {
		return ActionSupport.SUCCESS;
	}

	public Date getSalida(){
		Calendar c=Calendar.getInstance();
		c.set(2017, 3, 27);
		Date f=c.getTime();
		return f;
	}
	
	public int getPrecio(){
		return 739;
	}

}
