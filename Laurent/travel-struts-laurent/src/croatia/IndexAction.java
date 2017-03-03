package croatia;

import com.opensymphony.xwork2.ActionSupport;

//Class action
public class IndexAction extends ActionSupport{

	private static final long serialVersionUID = -7862180221959903011L;
	
	//Déclaration d'un bean à utliser, répertorié dans applicationContext.xml
	private CroatiaMessenger croatiaMessenger;
	
	
	//ACCESSEUR
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
