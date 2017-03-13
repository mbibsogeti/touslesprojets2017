package fr.ib.travel;

import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@EnableGemfireRepositories
public class LakeSource {
	
	private LakeRepository repository;
	
	public String getInfos(){
		String liste="lacs :"+"\n";
		for(Lake lac:repository.findAll()){
			liste=liste+lac.toString()+"\n";
		}
		return liste;
	}
	
	public String getGrandsLacs(){
		String liste="Grands lacs :"+"\n";
		for(Lake lac:repository.findBySizeGreaterThan(1000)){
			liste=liste+lac.toString()+"\n";
		}
		return liste;
	}
	
	public String getInfos(long l){
		return repository.findOne(l).toString();
	}
	
	public void fillInfos(){
		repository.save(new Lake(1L,"Lac Vanern","Suède",5648));
		repository.save(new Lake(2L,"Lac Suvasvesi","Finlande",234));
		repository.save(new Lake(3L,"Lac Saimaa","Finlande",4380));
		repository.save(new Lake(4L,"Lac Malar","Suède",5648));
	}

	public LakeRepository getRepository() {
		return repository;
	}

	public void setRepository(LakeRepository repository) {
		this.repository = repository;
	}

	
}
