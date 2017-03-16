package fr.ib.travel.tapestry.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;

@Import(stylesheet={"css/bonito.css"})
public class Layout {

	// @Property: définition d'une propriété, comme si on faisait un getter. On
	// peut l'appeler avec ${title} partout dans Layout.tml
	@Property
	// @Parameter: accorde la valeur par défaut de la propriété title telle qu'elle est définie dans la balise html dans
	// Index.tml
	@Parameter(defaultPrefix = BindingConstants.LITERAL)
	private String title;

}
