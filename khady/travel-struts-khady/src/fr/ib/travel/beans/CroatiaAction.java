package fr.ib.travel.beans;



import com.opensymphony.xwork2.ActionSupport;

public class CroatiaAction {
	private CroatiaMessenger croatiaMessenger;
	
	public CroatiaMessenger getCroatiaMessenger() {
		return croatiaMessenger;
	}
	
	public void setCroatiaMessenger(CroatiaMessenger croatiaMessenger) {
		this.croatiaMessenger = croatiaMessenger;
	}
	public String execute() {
		
		return ActionSupport.SUCCESS;

	}
}
