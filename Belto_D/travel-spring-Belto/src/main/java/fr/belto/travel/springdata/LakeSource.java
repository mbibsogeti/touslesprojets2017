package fr.belto.travel.springdata;

import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@EnableGemfireRepositories("fr.belto.travel.springdata")// package du depot
public class LakeSource {
	private LakeRepository repository;
	public String getInfos(){
		return ("Lakes: ");
		
	}
	public LakeRepository getRepository() {
		return repository;
	}
	public void setRepository(LakeRepository repository) {
		this.repository = repository;
	}

	
}
