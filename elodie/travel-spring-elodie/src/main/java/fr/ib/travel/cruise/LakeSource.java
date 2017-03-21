package fr.ib.travel.cruise;

import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@EnableGemfireRepositories
public class LakeSource {
	private LakeRepository repository;
	public String getInfos(){
		String str = "";
		for (Lake l:repository.findAll()) {
			str += l.toString() + "\n";
		}
		 str+="Grands lacs:\n";
		 for (Lake l:repository.findBySizeGreaterThan(1000)) {
			 str+=l.toString() + "\n";
		 }
		 str+="Le plus petit lac est :\n";
		 for (Lake l:repository.findFirstBySizeGreaterThanOrderBySizeAsc(0)) {
			 str += l.toString() + "\n";
			 break;
		 }
		return str;
	}
	public LakeRepository getRepository() {
		return repository;
	}
	public void setRepository(LakeRepository repository) {
		this.repository = repository;
	}
	public void fillInfos(){
		repository.save(new Lake(1L, "Lac Vanern", "Suède", 5648f));
		repository.save(new Lake(2L, "Lac Malär", "Suède", 1140f));
		repository.save(new Lake(3L, "Lac Siljan", "Suède", 354f));
	}
}
