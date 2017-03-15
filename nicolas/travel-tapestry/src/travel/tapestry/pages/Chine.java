package travel.tapestry.pages;


import java.io.File;

import org.apache.tapestry5.ValidationException;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.upload.services.UploadedFile;
import org.slf4j.Logger; // injection via log4j

public class Chine {
	@Persist @Property
	private String n1;
	@Persist @Property
	private String tel1;
	@Persist @Property
	private String Vnumber;
	@Persist @Property
	private UploadedFile Visnumber;
	
	@Inject private Logger logger;
	@Persist @Property String formstatus;
	public Class<?> onSuccess(){
		
		logger.info(n1+"("+tel1+") enregistre"+Vnumber+"voyageurs");
		//formstatus pour afficher un message via les property   le double new file permet de créé un répertoir et les double antislach remplace les simpl slach en java qui n'existe pas sinon
		//traitement du fichier importé , sinon il existe d'autre methode java pure et donc la bibliothèque commonuploadfile est a mettre et utiliser pour cela 
		
		// danslle if , il y a une metjode de vérification d'un fichier..
		if(Visnumber!=null && !Visnumber.getFileName().toLowerCase().endsWith(".exe")){  Visnumber.write(new File (new File ("C:\\nicolas"),Visnumber.getFileName()));
			 }
		return Chine.class;
	}
	
	//déclenchemen d'exception 
public void onValidateFromTel1( String value )throws ValidationException{
	if(value==null ||  value. isEmpty()) return;// le return ici stop et sort de la fonction
	char[]chars = value.toCharArray();
	for(char c:chars)
		if(c!=chars[0])return;
	throw new ValidationException("erreur");


	
	
	
}
	
	// possible fonctin de traitement des formulaires : onPrepare() onValidate()  onSubmit() qui est appeler peu importe la validation  onSuccess()  et on Validate() 
	
}