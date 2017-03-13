package fr.obodrel.travel.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;

@Import(stylesheet="css/extends.css")
public class AsiaLayout {
	@Parameter(defaultPrefix=BindingConstants.LITERAL)
	private String _title = "FOOBAR";
	
	@Parameter(defaultPrefix=BindingConstants.LITERAL)
	private String _pageName;

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	} 

	public String getPageName() {
		return _pageName;
	}

	public void setPageName(String pageName) {
		_pageName = pageName;
	}

	public String getHome() {
		return "home";
	}
	public String getIran() {
		return "iran";
	}

	public String getActive(String menuName) {
		if(menuName.equals(_pageName)) {
			return "active";
		}
		return "";
	}
}