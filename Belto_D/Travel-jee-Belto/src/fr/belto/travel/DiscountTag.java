package fr.belto.travel;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DiscountTag extends SimpleTagSupport{
@Override
public void doTag() throws JspException,IOException{
		Writer out=getJspContext().getOut();
		out.write("<span style='paddind:50px); border-radiux:50px;background:#eca;"
				+ "front-weight:bold'>Promo!</span>");
		
	}

}
 