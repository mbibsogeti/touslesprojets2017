package fr.obodrel.lib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DiscountTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter outWriter = getJspContext().getOut();
		String outString = "";
		
		outString = "<span class=\"badge\">Promo!</span>";
		
		outWriter.write(outString);
		
		super.doTag();
	}
	
}
