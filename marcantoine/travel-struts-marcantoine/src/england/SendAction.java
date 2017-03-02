package england;

import com.opensymphony.xwork2.ActionSupport;

public class SendAction extends ActionSupport {

	public String name, email;
	public boolean luxury;

	// Fonction pour examiner les champs et réagir en fonction
	public void validate() {
		if ("".equals(name)) {
			// en passant dans addFieldError, on a forcément la valeur "input"
			// dans la zone mémoire de ActionSupport ce qui permet de choisir un
			// "result" via struts.xml
			addFieldError("name", "mandatory");
		}
	}

	// NB : On pourrait mettre l'étape de validation (le contenu de la fonction "validate()") dans cette fonction.
	public String execute() {
		return ActionSupport.SUCCESS;
	}

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
