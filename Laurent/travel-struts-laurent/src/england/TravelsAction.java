package england;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.opensymphony.xwork2.ActionSupport;

public class TravelsAction extends ActionSupport{
	//Définit si l'action s'est bien déroulé
	public String execute(){
		
		return ActionSupport.SUCCESS;
	}
	
	//Définit un attribut dont on aura accès à l'affichage
	public List<Object> getDateP(){
		Calendar c=Calendar.getInstance();
		c.set(2017, 3, 27);
		Date date=c.getTime();
		int prix = 739;
		List<Object> result = new ArrayList<>();
		result.add(date);
		result.add(prix);
		return result;
	}
}
