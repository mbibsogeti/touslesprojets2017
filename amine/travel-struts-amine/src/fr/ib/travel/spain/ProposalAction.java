package fr.ib.travel.spain;

import com.opensymphony.xwork2.ActionSupport;

import fr.ib.travel.data.HibernateUtil;

public class ProposalAction extends ActionSupport {
	public String execute() {
		System.out.println("SUCCESS!");
		HibernateUtil.openSession();
		return ActionSupport.SUCCESS;
	}

}
