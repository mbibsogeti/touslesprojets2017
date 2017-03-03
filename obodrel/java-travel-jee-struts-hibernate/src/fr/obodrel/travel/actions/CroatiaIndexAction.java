package fr.obodrel.travel.actions;

import com.opensymphony.xwork2.ActionSupport;

import fr.obodrel.travel.beans.CroatiaMessenger;

@SuppressWarnings("serial")
public class CroatiaIndexAction extends ActionSupport {

	private CroatiaMessenger _croatiaMessenger;
	
	public String execute() {
		return ActionSupport.SUCCESS;
	}

	public void validate() {
	}

	public CroatiaMessenger getCroatiaMessenger() {
		return _croatiaMessenger;
	}

	public void setCroatiaMessenger(CroatiaMessenger croatiaMessenger) {
		_croatiaMessenger = croatiaMessenger;
	}
}
