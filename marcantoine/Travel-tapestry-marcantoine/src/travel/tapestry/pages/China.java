package travel.tapestry.pages;

import java.io.File;
import java.util.Locale;

import org.apache.tapestry5.ValidationException;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PersistentLocale;
import org.apache.tapestry5.upload.services.UploadedFile;
import org.slf4j.Logger;

public class China {
	@Inject
	private PersistentLocale pl;

	@Inject
	private Logger logger;

	@Property
	@Persist
	private String name, tel;

	@Property
	@Persist
	private int travelers;

	// Propriété pour envoyer des infos du client au serveur
	@Property
	private UploadedFile visa;

	@Inject
	private Messages messages;

	public void onChangeLocale(String l) {
		pl.set(new Locale(l));
	}

	// Fonction onSuccess appelée automatiquement lors de la validation de form.
	// Si "success" du formulaire, alors le contenu de la fonction s'exécute
	public Class onSuccess() {
		logger.info(name + " (" + tel + ") enregistre " + travelers + " voyageurs.");
		// Fonction permettant l'envoi d'un fichier du navigateur vers le
		// serveur. On y ajoute une condition pour éviter le téléchargement de
		// fichiers '.exe'. En principe, mieux de le faire en onValidate
		if (visa != null && !visa.getFileName().toLowerCase().endsWith(".exe"))
			// write : écrire le fichier qqpart, get pour avoir le nom du
			// fichier. Deux utilisations de la classe File : une pour désigner
			// le répertoire, une pour désigner le nom du fichier complet.
			// On met deux '\' pour que l'un échappe l'autre.
			visa.write(new File(new File("C:\\Users\\ib\\Documents\\"), visa.getFileName()));
		return Index.class;
	}

	// Fonction onValidate appelée automatiquement lors de la validation de
	// form. NB : 'return;' dans une fonction fait sortir de la fonction sans
	// renvoyer de valeur. 'throws ValidationException' permet de renvoyer une
	// exception si besoin.
	@Log public void onValidateFromTel(String value) throws ValidationException {
		if (value == null || value.isEmpty())
			return;
		char[] chars = value.toCharArray();
		for (char c : chars)
			if (c != chars[0])
				return;
		// Crée l'exception si besoin d'en renvoyer une.
		throw new ValidationException(messages.format("valexcept"));
	}
}
