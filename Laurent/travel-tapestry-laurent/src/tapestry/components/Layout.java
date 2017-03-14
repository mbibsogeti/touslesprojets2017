package tapestry.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;

@Import(stylesheet="css/titles.css")
public class Layout {

	@Property @Parameter(defaultPrefix=BindingConstants.LITERAL)
	private String title="Voyages";
	

}
