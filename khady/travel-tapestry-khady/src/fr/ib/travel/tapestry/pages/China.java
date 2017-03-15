package fr.ib.travel.tapestry.pages;

import java.io.File;

import org.apache.tapestry5.ValidationException;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.upload.services.UploadedFile;
import org.slf4j.Logger;

public class China {

	@Property
	@Persist
	private String name;
	@Property
	@Persist
	private int travelers;
	@Property
	@Persist
	private String tel;
	@Property
	private UploadedFile visa;

	@Inject
	private Logger logger;

	public Class onSuccess() {
		/* les lignes 31 et 32 permettent d'enregistrer un fichier dans l'emplacement "c:\\users\\ib\\documents\\" */
		if(visa != null && !visa.getFileName().toLowerCase().endsWith(".exe"))/* accepte ts les fichiers sauf .exe et ct juste un exple le .exe*/
			visa.write(new File(new File("c:\\users\\ib\\documents\\"), visa.getFileName()));
		logger.info("Les données pour " + name + " avec le numéro " + tel + " pour " + travelers
				+ " voyageurs sont enregistrées.");
		return Index.class;
	}

	public void onValidateFromTel(String value) throws ValidationException{
	
		if(value == null || value.isEmpty()) 
			return;/* le "return;" stoppe la fonction */
		char[] chars = value.toCharArray();
		for(char c: chars)
			if(c != chars[0])
				return;
		
			throw new ValidationException("Error Exception");
	}
	
	
}
