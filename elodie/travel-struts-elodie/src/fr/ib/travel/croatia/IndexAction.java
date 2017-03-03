package fr.ib.travel.croatia;


import com.opensymphony.xwork2.ActionSupport;


public class IndexAction {
	
	private CroatiaMessenger croatiaMessenger;

	public CroatiaMessenger getCroatiaMessenger() {
		return croatiaMessenger;
	}

	public void setCroatiaMessenger(CroatiaMessenger croatiaMessenger) {
		this.croatiaMessenger = croatiaMessenger;
	}

	public String execute(){
		return ActionSupport.SUCCESS;
	}
}
