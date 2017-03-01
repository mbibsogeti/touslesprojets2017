package fr.obodrel.travel.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class EnglandRegisterAction extends ActionSupport {
	
	private String _name;
	private String _email;
	private boolean _isLuxarySet;

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		this._name = name;
	}
	
	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		this._email = email;
	}

	public boolean isLuxary() {
		return _isLuxarySet;
	}

	public void setLuxary(boolean isLuxarySet) {
		this._isLuxarySet = isLuxarySet;
	}
	
	public String execute() {
		System.out.println("SUCCESS");
		return ActionSupport.SUCCESS;
	}
	
	public void validate() {	
		if(_name != null && !_name.equals("")) {
			Pattern patternName = Pattern.compile("^[A-Z ]*$", Pattern.CASE_INSENSITIVE);
			Matcher matcherName = patternName.matcher(_name);
			if(!matcherName.find()) {
				addFieldError("name", "Unsupported characters, please use only letters and numbers.");
				_name = null;
			}
		} else {
			addFieldError("name", "Required");
			_name = null;
		}
		if(_email != null && !_email.equals("")) {
			Pattern patternEmail = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
			Matcher matcherEmail = patternEmail.matcher(_email);
			if(!matcherEmail.find()) {
				addFieldError("email", "The email is not valid, please enter a real email.");
				_email = null;
			}
		} else {
			addFieldError("email", "Required");
			_email = null;
		}
	}

}
