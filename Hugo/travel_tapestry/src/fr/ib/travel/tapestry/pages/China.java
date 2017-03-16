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
	private String pasaj;
	@Property
	private UploadedFile visa;

	@Inject
	private Logger logger;

	public Class<Index> onSuccess() {
		logger.info(name + " (" + tel + ") registra " + pasaj + " viajeros");
		if (visa != null && !visa.getFileName().toLowerCase().endsWith(".exe")) {
			// le nom avec lequel va être écrit le fichier peut être différent
			// de celui d'origine, par ex "fototest.jpg"
			visa.write(new File(new File("c:\\users\\ib\\documents\\"), visa.getFileName()));
		}
		return Index.class;
	}

	private int i = 0;

	public void onValidateFromTel(String value) throws ValidationException {
		if (value == null || value.isEmpty()) {
			return;
		}
		for (i = 1; i <= 9; i++) {
			String c = String.valueOf(i) + String.valueOf(i) + String.valueOf(i) + String.valueOf(i) + String.valueOf(i)
					+ String.valueOf(i) + String.valueOf(i) + String.valueOf(i) + String.valueOf(i) + String.valueOf(i);
			if (value.equals(c)) {
				// Tapestry fait que throw new ValidationException(...) envoie
				// un message dans le navigateur comme s'il s'agissait d'un
				// message de validation défini dans le fichier China.properties
				throw new ValidationException("El numero de teléfono no puede estar compuesto por la misma cifra.");
			}
		}
	}
}
