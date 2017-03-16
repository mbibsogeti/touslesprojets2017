package fr.ib.travel.tapestry.pages;

import java.io.File;

import org.apache.tapestry5.ValidationException;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.upload.services.UploadedFile;
import org.slf4j.Logger;

public class China {
	@Persist @Property private String nom,tel;
	@Persist @Property private int nb_v;
	@Property private UploadedFile visa;
	@Inject private Logger logger;
	
	public void onPrepare(){}
	public void onValidate(){}
	
	public void onValidateFromTel(String value) throws ValidationException{
		if (value==null || value.isEmpty()) 
			return;
		char[] chars = value.toCharArray();
		for (char c:chars)
			if (c!=chars[0])
				return;
		throw new ValidationException("Il manque quelque chose ... ");
	}
	
	public String onSuccess(){
		if ((visa!=null) && !(visa.getFileName().toLowerCase().endsWith(".exe")))
			logger.info("loading ..... !"+visa.getFileName());
			visa.write(new File(new File("C:\\Users\\ib\\Documents\\"), visa.getFileName()));
		logger.info(nom+"("+tel+") enregistré "+nb_v+" voyageurs");
		return "Index";
	}
	public void onFailure(){}
	public void onSubmit(){
		
	}

}
