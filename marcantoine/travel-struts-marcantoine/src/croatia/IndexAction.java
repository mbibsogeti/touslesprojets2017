package croatia;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import data.Comment;
import data.HibernateUtil;
import data.Monument;

public class IndexAction extends ActionSupport {

	private CroatiaMessenger croatiaMessenger;
	
	public String execute() {
		return ActionSupport.SUCCESS;
	}

	public CroatiaMessenger getCroatiaMessenger() {
		return croatiaMessenger;
	}

	public void setCroatiaMessenger(CroatiaMessenger croatiaMessenger) {
		this.croatiaMessenger = croatiaMessenger;
	}

}
