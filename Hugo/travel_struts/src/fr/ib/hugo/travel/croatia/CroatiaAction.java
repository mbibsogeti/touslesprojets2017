package fr.ib.hugo.travel.croatia;

import com.opensymphony.xwork2.ActionSupport;

public class CroatiaAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private CroatiaMessenger croatiaMessenger;

	public CroatiaMessenger getCroatiaMessenger() {
		System.out.println("testget");
		return croatiaMessenger;
	}

	public void setCroatiaMessenger(CroatiaMessenger croatiaMessenger) {
		System.out.println("testset");
		this.croatiaMessenger = croatiaMessenger;
	}

	public String execute() {
		return ActionSupport.SUCCESS;
	}

}
