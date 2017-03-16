package tapestry.pages;

import org.slf4j.Logger;

import java.io.File;

import org.apache.tapestry5.ValidationException;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.upload.services.UploadedFile;

public class China {
	
	//Propriétés
	@Persist @Property private String name;
	@Persist @Property private String tel;
	@Persist @Property private long travelers;
	@Persist @Property private UploadedFile visa;
	@InjectPage private Index pageIndex;
	
	//Obtenir un loggeur
	@Inject private Logger logger;
	
	//Methodes liées au formulaire
	//Methode à appliquer en cas de succès
	public Index onSuccess(){
		logger.info("Données rentrées : "+name+", "+tel+", "+"nb-travelers="+travelers+", "+"Fichier de visa : "+((visa != null)?visa.getFilePath():"null"));
		
		//Utilisation de l'uploaded
		if(visa!=null){
			try{
			visa.write(new File(new File("c:\\Users\\ib\\documents\\"),visa.getFileName()));
			}catch(Exception ex){
				System.out.println("Error !!"+ex.toString());
			}
		}
		
		return pageIndex;
	}
	
	//Methodes à appliquer pour la validation des champs rentrées
	public void onValidateFromTel(String value) throws ValidationException{
	
		//Test la présence d'un numéro
		if(value==null||value.isEmpty()) return;
		
		//Récupère chaque chiffre dans un tableau
		char[] number=value.toCharArray();
		//Test l'égalité de chaque chiffre au premier chiffre
		for(char chiffre:number){
			if(chiffre!=number[0]){
				return;
			}
		}
		//Retourne une exception si tous les chiffres sont identiques
		throw new ValidationException("Ce numéro n'est pas reconnue");
	}
	
	public void onValidateFromVisa(UploadedFile value)throws ValidationException{
		if(visa==null||visa.getFileName().toLowerCase().endsWith(".exe")){
			throw new ValidationException("Les fichiers exécutable ne sont pas admis !");
		}
	}
}
