package jk.travel.angleterre;

import com.opensymphony.xwork2.ActionSupport;

public class AngleterreSend extends ActionSupport {
	/**
	 * La classe AngleterreSend regarde d'abord validate(). Si c'est bon, elle regarde ensuite execute().
	 */

	// ATTRIBUTS //
	private String _name;
	private String _mail;
	private boolean _luxury;

	// MÉTHODES //
	public String execute() {
		System.out.println("Enregistré !");
		return ActionSupport.SUCCESS;
	} // end execute method

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getMail() {
		return _mail;
	}

	public void setMail(String mail) {
		_mail = mail;
	}

	public boolean isLuxury() {
		return _luxury;
	}

	public void setLuxury(boolean luxury) {
		_luxury = luxury;
	}
	
	// validate() est aussi un nom clef
	public void validate() {
		if("".equals(_name)) {
			addFieldError("name", "Obligatoire");
		} // end if
	} // end validate method
} // end AngleterreSend class