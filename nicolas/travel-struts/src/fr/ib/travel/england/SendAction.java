package fr.ib.travel.england;

import com.opensymphony.xwork2.ActionSupport;

public class SendAction extends ActionSupport{
private String name,email;
private boolean luxury;
	
	
	/**
 * @return the name
 */
public String getName() {
	return name;
}


/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}


/**
 * @return the email
 */
public String getEmail() {
	return email;
}


/**
 * @param email the email to set
 */
public void setEmail(String email) {
	this.email = email;
}




	/**
 * @return the luxury
 */
public boolean isLuxury() {
	return luxury;
}


/**
 * @param luxury the luxury to set
 */
public void setLuxury(boolean luxury) {
	this.luxury = luxury;
}
public void validate(){  // spécial de struts pour géré les erreur renvoi soit input soit succes 
	
	if("".equals(name))
		addFieldError("name","Obligatoire");
}

	public String execute() {
		
		System.out.println("enregistre");
		return ActionSupport.SUCCESS;
	}
	

}

