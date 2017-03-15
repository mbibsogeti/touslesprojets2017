package fr.ib.travel.tapestry.pages;

import java.io.File;

import org.apache.tapestry5.ValidationException;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.upload.services.UploadedFile;
import org.slf4j.Logger;


public class Chine {
	@Property @Persist private String inputNom;
	@Property @Persist private String inputTel;
	@Property @Persist private String inputNbV;
	@Property private UploadedFile inputVisa;
	
	@Inject private Logger logger;
	public Class<?> onSuccess(){
		logger.warn("Nom: " +inputNom+", Tel: "+inputTel+", NbVoyageurs: "+inputNbV);
		
		if(inputVisa !=null)
			inputVisa.write(new File(new File("c:\\users\\ib\\documents\\"),inputVisa.getFileName()));
		return Index.class;		
	}
	public void onValidateFromInputTel(String value) throws ValidationException{
		if(value==null || value.isEmpty()) return;
		char[] chars = value.toCharArray();
		
		for(char c:chars) if (c!=chars[0]) return;
		throw new ValidationException("ERREUR");
		
//		Mon algorithme
		
//		Boolean v=false;
//		int compare = 0;
//		
//		for (int i =0; i<value.length(); i++) compare += value.substring(i).compareTo(value.substring(i+1));
//		if (compare == value.length()) v = true;	
//		if(v)throw new ValidationException("ERREUR");
	}

}
