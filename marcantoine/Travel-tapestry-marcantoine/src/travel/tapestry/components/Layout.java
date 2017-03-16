// Ce package est défini par : 'package donné en web.xml dans tapestry.app-package'.components
package travel.tapestry.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;

// Utilisation d'une ressource extérieure, ici un fichier CSS : 'titles.css', avec une annotation
// spécifique : '@Import'.
@Import(stylesheet="css/titles.css")
public class Layout {

	// @Property
	// @Parameter
	@Property
	@Parameter(defaultPrefix = BindingConstants.LITERAL)
	private String title="Trips";

}