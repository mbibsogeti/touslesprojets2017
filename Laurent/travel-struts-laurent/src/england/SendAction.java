package england;
import com.opensymphony.xwork2.ActionSupport;

public class SendAction extends ActionSupport{
	
	private String name,email;
	private boolean luxury;
	
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

	//Définit si l'action s'est bien déroulé
	public String execute(){
		System.out.println("enregistré");
		return ActionSupport.SUCCESS;
	}
	
	public void validate(){
		if("".equals(name)) addFieldError("name", "Obligatoire");
		if("".equals(email)) addFieldError("email", "Obligatoire");
	}
}
