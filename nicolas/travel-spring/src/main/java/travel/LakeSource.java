package travel;

import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@EnableGemfireRepositories("travel") // veu dire fouille dans le pakage si ya cela va permetre d'utiliser les findby et autre truc de recherche 

										// des lake, l'interface
public class LakeSource {
	private LakeRepository repository;//création du dépot de lac 

	public LakeRepository getRepository() {
		return repository;
	}

	public void setRepository(LakeRepository repository) {
		this.repository = repository;
	}

	public Object getInfo() {  //pour récupérer les info du dépo de lac 
		String listlake = "";
		// Lake l1=repository.findOne(1L); car ne sert plus a rien
		//for (Lake l : repository.findAll())
			//listlake += l + "\n";
		//on peu avoir des findBySize lessthan between like  and et or son possible. et on peu aussi mettre order by 
		for(Lake l:repository.findBySizeGreaterThanOrderByName(10))//il existe aussi lessthan ou d'autre truc le find by marche avec les annotations @
	    listlake+= l+"\n";
		return listlake;
	
	}

	public void fillInfos() {
		repository.save(new Lake(1L, "lac vanerm", "suede", 5845)); // le l
																	// après le
																	// ID
																	// indique
																	// que c'est
																	// converti
																	// en ong on
																	// n emet
																	// pas f a
																	// la fin ca
																	// c'est des
																	// entier si
																	// ct de
																	// virgule
																	// on le
																	// mettrai
																	// pour
																	// convertir
																	// car par
																	// défaut
																	// c'est des
																	// doubles
		repository.save(new Lake(2L, "lac powell", "usa", 45));
		repository.save(new Lake(3L, "lac bleu", "france", 55));
		repository.save(new Lake(4L, "lac vanerm", "suede", 5845));

	}
}
