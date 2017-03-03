package tag;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class RandomTag extends SimpleTagSupport {

	public RandomTag() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doTag() throws JspException, IOException {
		Writer out= getJspContext().getOut();
		int nb = (int)( Math.random()*( 5 - 0 + 1 ) ) + 0;
		out.write(""+nb);
	}

}
