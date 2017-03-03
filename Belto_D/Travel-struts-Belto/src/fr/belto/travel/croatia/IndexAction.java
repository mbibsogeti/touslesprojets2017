package fr.belto.travel.croatia;

import java.util.List;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import fr.belto.travel.hibernate.HibernateUtil;
import fr.belto.travel.hibernate.Monument;

public class IndexAction {
	private CroatiaMessenger croatiaMessenger;
	
	public CroatiaMessenger getCroatiaMessenger() {
		return croatiaMessenger;
	}

	public void setCroatiaMessenger(CroatiaMessenger croatiaMessenger) {
		this.croatiaMessenger = croatiaMessenger;
	}

	public String execute(){
		Session s=HibernateUtil.openSession();
				s.close();
				return ActionSupport.SUCCESS;
					}
}
