package jk.travel.croatie;

import com.opensymphony.xwork2.ActionSupport;

public class CroatieIndexAction {

	// ATTRIBUTS //
	private CroatieMessenger _croatieMessenger;

	// MÉTHODES //
	public String execute() {
		return ActionSupport.SUCCESS;
	} // end execute method

	public CroatieMessenger getCroatieMessenger() {
		return _croatieMessenger;
	}

	public void setCroatieMessenger(CroatieMessenger croatieMessenger) {
		_croatieMessenger = croatieMessenger;
	}
}