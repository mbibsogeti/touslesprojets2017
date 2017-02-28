package jk.travel.amsud.tag;

import java.io.IOException;
import java.io.Writer;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DiscountTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		// Obtenir la main sur le flux de sortie
		Writer out = getJspContext().getOut();
		out.write("<span style='padding: 50px; border-radius: 50px; background: #ECA; font-weight: bold'> Promo ! </span>");
	} // end doTzg method
} // end DiscountTag class