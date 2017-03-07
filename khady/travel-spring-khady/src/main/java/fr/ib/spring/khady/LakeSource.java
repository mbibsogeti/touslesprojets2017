package fr.ib.spring.khady;

import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@EnableGemfireRepositories
public class LakeSource {

	private LakeRepository repository;
	
	public LakeRepository getLakerepository() {
		return repository;
	}

	public void setLakerepository(LakeRepository repository) {
		this.repository = repository;
	}
	
	public void fillInfos(){
		repository.save(new Lake(1L, "Lac Vanern", "Suede", 5648));
		repository.save(new Lake(2L, "Lac Vattern", "Suede", 1912));
		repository.save(new Lake(3L, "Lac Malar", "Suede", 1140));
		repository.save(new Lake(4L, "Lac Storsjon", "Suede", 464));
		repository.save(new Lake(5L, "Lac Akkajaure", "Suede", 266));
	}
	
	
	
	public String getInfos() {
		/*Lake l1 = repository.findOne(1L); si on veut juste afficher les elemts ayant l'Id 1L */
		String s ="";
		//for(Lake l:repository.findAll())
		//s += l+"\n";
		//return s;		
		s += "Les lacs qui font plus 1000 Km² sont :\n";
		for(Lake l:repository.findBySizeGreaterThan(1000))		
	    s += l+"\n";	
		return s;		
		
	}	
}


