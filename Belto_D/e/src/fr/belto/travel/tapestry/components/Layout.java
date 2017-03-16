package fr.belto.travel.tapestry.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
@Import (stylesheet="css/titles.css")
public class Layout{
//property pour l'affichage ${title}
// Parameter pour utiliser title dans Index.tml
// Du coup il faut mette(defaultPrefix........LITERAL)...
// si on utilise les deux, celui de la fonction String sera ecrasé
@Property @Parameter(defaultPrefix=BindingConstants.LITERAL) private String title;
}
