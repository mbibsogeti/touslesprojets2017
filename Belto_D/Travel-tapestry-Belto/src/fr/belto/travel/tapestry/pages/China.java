package fr.belto.travel.tapestry.pages;

import java.io.File;

import org.apache.tapestry5.ValidationException;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.upload.services.UploadedFile;
import org.slf4j.Logger;

public class China {
// Persist pour garder les champs remplient après envoi
// property pour declarer et relier les id dans textfield, obligatoire
@Persist @Property private String name;
@Persist @Property private String tel;
@Persist  @Property private int travelers;
@Property private UploadedFile visa;
@Inject private Logger logger;
// On lui dit de logger dans la console en cas de succès
// et en plus de renvoyer vers l'accueil d'Asie
public Class<?> onSuccess(){
	logger.info(name+ "("+tel+") enregistré"+travelers+"voyageurs");
//si le champ visa n'est pas null et que ce n'est pas un .exe alors on l'enregistre
// visa getFile name va chercher le fichier avec le bon nom du fichier
// new file("c:.....") va creer le dossier dans le chemin indiqué
// le second new File(on va chercher le fichier avec le bon nom et le creer)
// c'est possible grace à la balise upload de tapestry (n'est pas possible en JEE pur)
	if (visa!=null && !visa.getFileName().toLowerCase().endsWith("exe"))
		 visa.write(new File(new File("c:\\users\\ib\\documents\\"),visa.getFileName()));
	return Index.class;
}
// empecher numeros bidon
public void onValidateFromTel(String value)throws ValidationException{
	if(value==null || value.isEmpty()) return;
	  char[] chars=value.toCharArray();
	  for(char c:chars)
		  if(c!=chars[0])
			  return;
		throw new ValidationException("<h1>Haha petit malin, numéro bidon</h1>");
}
}
