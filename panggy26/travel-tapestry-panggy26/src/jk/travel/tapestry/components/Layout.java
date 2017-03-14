package jk.travel.tapestry.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;

// Ancienne syntaxe : @Import(stylesheet="asset:css/titles.css"). L'appel à asset est devenue implicite.
@Import(stylesheet = "css/titles.css")
public class Layout {

	// ATTRIBUTS //
	// @Property : Les Getter et Setter sont automatiquement faits, on peut utiliser ${title}. Attention, cela ne fonctionne pas si l'on
	// nomme l'attribut avec un _
	// @Parameter : La donnée qui vient d'Index.tml est lue par le layout.
	@Property
	@Parameter(defaultPrefix = BindingConstants.LITERAL)
	private String title = "Voyages, voyages !"; // Valeur par défaut si rien dans title="Les voyages asiatiques" d'index.tml
} // end Layout class