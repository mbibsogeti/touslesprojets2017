package fr.ib.travel.croatie;

import com.opensymphony.xwork2.ActionSupport;

public class CroatieAction {
	
	private CroatiaMessenger croatiaMessenger;
	
	public String execute(){
		return ActionSupport.SUCCESS;	
	}

	public CroatiaMessenger getCroatiaMessenger() {
		return croatiaMessenger;
	}

	public void setCroatiaMessenger(CroatiaMessenger croatiaMessenger) {
		this.croatiaMessenger = croatiaMessenger;
	}

}
