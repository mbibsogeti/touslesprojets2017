package jk.travel.angleterre;

import java.util.Calendar;
import java.util.Date;
import com.opensymphony.xwork2.ActionSupport;

public class AngleterreIndex extends ActionSupport {

	// ATTRIBUTS //
	int prix = 739;

	// MÉTHODES //
	public String execute() {
		return ActionSupport.SUCCESS;
	} // end execute method

	public Date getDepart() {
		Calendar calendrier = Calendar.getInstance();
		// 0 : janvier, ..., 3 : avril
		calendrier.set(2017, 3, 27);
		Date date = calendrier.getTime();
		return date;
	} // end getTemps method

	public int getPrix() {
		int prix = 739;
		return prix;
	} // end getPrix method
} // end Angleterre class