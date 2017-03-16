package fr.ib.travel.tapestry.pages;

import java.io.File;

import org.apache.tapestry5.ValidationException;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.upload.services.UploadedFile;
import org.slf4j.Logger;

public class China {

	@Property
	private String name;

	@Property
	private String tel;

	@Property
	private String travelers;
	@Property
	private UploadedFile visa;

	@Inject
	private Logger logger;

	// <?> une classe de n'importe quelle type
	public Class<?> onSuccess() {
		if (visa != null && !visa.getFileName().toLowerCase().endsWith(".exe"))
			visa.write(new File(new File("c:\\users\\ib\\documents\\"), visa.getFileName()));
		logger.info(name + "(" + tel + ") enregistre " + travelers + " voyageurs");
		return Index.class;
	}

	public void onValidateFromTel(String value) throws ValidationException {
		// isEmpty() chaîne vide
		if (value == null || value.isEmpty())
			return;
		char[] chars = value.toCharArray();
		for (char c : chars) {
			if (c != chars[0])
				return;
		}
		throw new ValidationException("Merci de bien remplir la case Tel");
	}
}
