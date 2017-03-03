package fr.ib.travel.croatia;

import com.opensymphony.xwork2.ActionSupport;
//cette casse sert d'intermédiaire pour envoyer des message , ilregarde au démarage,si besoin de croatia messenger, et oui ya dans le context application et donc lors de l'appel dans la jsp il va chercher grace au id et classe de application Context l" essafe stocker dans une classe de message 

public class IndexAction extends ActionSupport{
private CroatiaMessenger croatiaMessenger;

		/**
 * @return the croatiaMessenger
 */
public CroatiaMessenger getCroatiaMessenger() {
	return croatiaMessenger;
}

/**
 * @param croatiaMessenger the croatiaMessenger to set
 */
public void setCroatiaMessenger(CroatiaMessenger croatiaMessenger) {
	this.croatiaMessenger = croatiaMessenger;
}

		public String execute() {
			
		
	return ActionSupport.SUCCESS;

}
}
