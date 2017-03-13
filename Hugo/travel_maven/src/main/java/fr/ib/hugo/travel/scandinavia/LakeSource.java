package fr.ib.hugo.travel.scandinavia;

import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@EnableGemfireRepositories("fr.ib.hugo.travel.scandinavia")
public class LakeSource {

	private LakeRepository repository;

	public LakeRepository getRepository() {
		return repository;
	}

	public void setRepository(LakeRepository repository) {
		this.repository = repository;
	}

	public String getInfos() {
		// Lake l;
		// return l = repository.findOne(2L);
		String s = "";
		for (Lake l : repository.findAll()) {
			s += l + "\n";
		}
		s+="Lagos grandes:\n";
		for(Lake l:repository.findBySizeGreaterThanOrderByIdAsc(0)){
			s += l + "\n";
		}
		s+="Lagos pequeños:\n";
		for(Lake l:repository.findBySizeLessThan(1000)){
			s += l + "\n";
		}
		return s;
	}

	// L dans id pour long
	public void fillInfos() {
		repository.save(new Lake(1L, "Lago Vattern", "Suecia", 5648));
		repository.save(new Lake(2L, "Lago Malar", "Suecia", 2201));
		repository.save(new Lake(3L, "Lago Vanern", "Suecia", 502));
		repository.save(new Lake(4L, "Lago Silijan", "Suecia", 988));
	}
}
