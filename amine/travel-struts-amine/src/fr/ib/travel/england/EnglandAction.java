package fr.ib.travel.england;

import java.util.Calendar;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class EnglandAction extends ActionSupport {
	
	public Date getDeparture() {
		Calendar c = Calendar.getInstance();
		//le mois est indexé à 0. pour afficher le 27/04/2017
		c.set(2017, 3, 27);
		Date d = c.getTime();
		return d;
	}

	public int getPrice() {
		int prix = 739;
		return prix;
	}

}
