/**
 * 
 */
package fr.ib.travel.amine;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author ib
 *
 */
public class DiscountTag extends SimpleTagSupport {
	public void doTag() throws JspException, IOException {
		Writer out = getJspContext().getOut();
		out.write("<span style='padding:50px;border-radius:50px;background:#eca;font-weight:bold'>Promo!</span>");
	}
}
