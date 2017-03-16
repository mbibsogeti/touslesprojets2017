package jk.travel.tapestry.pages;

import java.io.File;

import org.apache.tapestry5.ValidationException;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.upload.services.UploadedFile;
import org.slf4j.Logger;

public class Chine {
	
	// ATTRIBUTS //
	@Property @Persist
	// @Property : fait le lien avec le fichier .tml
	// @Persist : garde les valeurs après envoi du formulaire. Stockage en session.
	private String nom;
	
	@Property @Persist
	private String tel;
	
	@Property @Persist
	private UploadedFile visa;
	
	@Property @Persist
	private int nbVoyageurs;
	
	@Inject
	private Logger logger;
	
	// MÉTHODES //
	public Class<Index> onSuccess() {
		// Écriture du visa dans un fichier
		// Si le visa n'est pas nul et que son nom ne se termine pas par .exe (attention aux virus !)
		if(visa != null && !visa.getFileName().toLowerCase().endsWith(".exe")) {
			// Désignation du répertoire avec échappement de \
			File DesiRepertoire = new File("c:\\users\\ib\\desktop\\");
			// visa.getFileName() : on récupère le nom du fichier. On aurait pu l'appeler "truc"
			visa.write(new File(DesiRepertoire, visa.getFileName()));
		}
		// Phrase de validation d'enregistrement
		logger.info("Demande enregistrée pour " + nom + " pour " + nbVoyageurs + " voyageur(s) au numéro " + tel);
		return Index.class;
	}
	
//	// Version Mickaël
//	public void onValidateFromTel(String value) throws ValidationException {
//		// S'il n'y a pas de valeur, on arrête la fonction. Ce cas a été pris en compte par le validate="required"
//		if(value == null || value.isEmpty()) {
//			return;
//		}
//		// Définition d'un tableau de caractères
//		char[] chars = value.toCharArray();
//		for(char i : chars) {
//			// Si le caractère i est différent du premier, on arrête la fonction. C'est OK.
//			if(i != chars[0]) {
//				return;
//			}
//		}
//		// Si on n'a pas rencontré un des cas précédents, on lève l'exception
//		throw new ValidationException("Votre numéro est bidon : tous les chiffres sont identiques !");
//	} // end onValidateFromTel method
	
	// Ma version
	public void onValidateFromTel(String value) throws ValidationException {
		// S'il n'y a pas de valeur, on arrête la fonction. Ce cas a été pris en compte par le validate="required"
		if(value == null || value.isEmpty()) {
			return;
		}
		for(int i = 0 ; i < value.length() - 1 ; i++) {
			// Si le caractère i est différent du premier, on arrête la fonction. C'est OK.
			if(!(value.substring(i, i + 1).equals(value.substring(0, 1)))) {
				return;
			}
		}
		// Si on n'a pas rencontré un des cas précédents, on lève l'exception
		throw new ValidationException("Votre numéro est bidon : tous les chiffres sont identiques !");
	} // end onValidateFromTel method
} // end Chine class