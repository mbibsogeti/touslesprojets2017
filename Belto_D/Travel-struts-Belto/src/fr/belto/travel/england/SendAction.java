package fr.belto.travel.england;

import com.opensymphony.xwork2.ActionSupport;

public class SendAction extends ActionSupport {
	private String name, email;// on passe name et email en attribut
	private boolean luxury;// luxury en boolean
	public String execute(){
		System.out.println("enregistré");
		 return ActionSupport.SUCCESS;//c'est le meme pour action "result=succès"
	}
@Override
	public void validate(){// fonction qu'il vérifie avant de faire execute
		if("".equals(name))// la fonction validate est standard et reconnu, si il y a erreur la function exectute n'est pas executée!
			addFieldError("name","Attention un nom est obligatoire!");// à afficher au cas ou l'utilisateur ne rentre pas de nom
	}
	// les getters and setters (click droit/source/ generate getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isLuxury() {
		return luxury;
	}
	public void setLuxury(boolean luxury) {
		this.luxury = luxury;
	}
	
}
