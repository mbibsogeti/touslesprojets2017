package fr.ib.tags;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DiscountTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
	Writer out= getJspContext().getOut();
	out.write("<span style='padding:50px; border-radius:50px; background:#eca; font-weight:bold'>Promo 15% !</span>");
	
	
	
	
	}

	
}
