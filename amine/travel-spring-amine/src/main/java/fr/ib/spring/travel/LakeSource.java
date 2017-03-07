package fr.ib.spring.travel;

import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@EnableGemfireRepositories
public class LakeSource {

	public String getInfos() {
		String s="";
		//pour un élément
		Lake l1=repository.findOne(1L);
		//pour tout afficher
		//for (Lake l:repository.findAll())
			//on peut mettre juste un l
		s+="Grands lacs: \n";
		for(Lake l:repository.findBySizeGreaterThan(1000))
			s+=l.toString()+"\n";
		return s;
	}

	private LakeRepository repository;

	public LakeRepository getRepository() {
		return repository;
	}

	public void setRepository(LakeRepository repository) {
		this.repository = repository;
	}

	// information sur les lacs
	public void fillInfos() {
		repository.save(new Lake(1L, "Lac Vanern", "Suède", 5648));
		repository.save(new Lake(2L, "Lac Vattern", "Suède", 4503));
		repository.save(new Lake(3L, "Lac Malar", "Suède", 1140));
		repository.save(new Lake(4L, "Lac Mjosa", "Norvège", 362));
		repository.save(new Lake(5L, "Lac Tyrifjord", "Norvège", 136));
	}
}