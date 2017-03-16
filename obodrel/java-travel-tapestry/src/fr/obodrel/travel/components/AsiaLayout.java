package fr.obodrel.travel.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Parameter;

import fr.obodrel.travel.pages.Birmania;
import fr.obodrel.travel.pages.Cambodia;
import fr.obodrel.travel.pages.China;
import fr.obodrel.travel.pages.Index;
import fr.obodrel.travel.pages.India;
import fr.obodrel.travel.pages.Iran;
import fr.obodrel.travel.pages.Japan;
import fr.obodrel.travel.pages.Korea;

@Import(stylesheet="css/extends.css")
public class AsiaLayout {
	@Parameter(defaultPrefix=BindingConstants.LITERAL)
	private String _title = "FOOBAR";
	
	@Parameter(defaultPrefix=BindingConstants.LITERAL)
	private String _pageName;
	
	
    @InjectPage
    private Index indexPage;
    @InjectPage
    private Iran iranPage;
    @InjectPage
    private India indiaPage;
    @InjectPage
    private Cambodia cambodiaPage;
    @InjectPage
    private Birmania birmaniaPage;
    @InjectPage
    private China chinaPage;
    @InjectPage
    private Japan japanPage;
    @InjectPage
    private Korea koreaPage;

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
    public Object onToHome() {
    	return indexPage;
    }
    
	public String getIran() {
		return "iran";
	}
    public Object onToIran() {
    	return iranPage;
    }
    
	public String getIndia() {
		return "india";
	}
    public Object onToIndia() {
    	return indiaPage;
    }
    
	public String getCambodia() {
		return "cambodia";
	}
    public Object onToCambodia() {
    	return cambodiaPage;
    }
    
	public String getBirmania() {
		return "birmania";
	}
    public Object onToBirmania() {
    	return birmaniaPage;
    }
    
	public String getChina() {
		return "china";
	}
    public Object onToChina() {
    	return chinaPage;
    }
    
	public String getJapan() {
		return "japan";
	}
    public Object onToJapan() {
    	return japanPage;
    }
    
	public String getKorea() {
		return "korea";
	}
    public Object onToKorea() {
    	return koreaPage;
    }

	public String getActive(String menuName) {
		if(menuName.equals(_pageName)) {
			return "active";
		}
		return "";
	}
}