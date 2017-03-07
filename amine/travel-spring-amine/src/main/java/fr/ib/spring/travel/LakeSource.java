package fr.ib.spring.travel;

import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@EnableGemfireRepositories
public class LakeSource {

	public String getInfos() {
		return "lacs:";
	}

	private LakeRepository repository;

	public LakeRepository getRepository() {
		return repository;
	}

	public void setRepository(LakeRepository repository) {
		this.repository = repository;
	}

}