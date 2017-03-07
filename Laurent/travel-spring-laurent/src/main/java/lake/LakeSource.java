package lake;

import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

import main.LakeRepository;

@EnableGemfireRepositories("main")//Lance la fabrication automatique de la class correspondant au repository
public class LakeSource {

	//ATTRIBUTS
	private LakeRepository repository;
	
	//ACCESSEURS
	public LakeRepository getRepository() {
		return repository;
	}

	public void setRepository(LakeRepository repository) {
		this.repository = repository;
	}
	
	//METHODES
	public String getInfos(Float surface) {
		String infos="";
		for(Lake l:repository.findBySizeGreaterThan(surface)){
			infos+=l+"\n";
		}
		return infos;
	}
	
	public String getInfos(Long id) {
		String infos="";	
		Lake lake=repository.findOne(id);
		infos+=lake.toString();
		return infos;
	}
	
	public String getInfos() {
		String infos="";
		for(Lake l:repository.findAll()){
			infos+=l.toString()+"\n";
		}
		return infos;
	}
	
	public void fillInfos(){
		repository.save(new Lake(1L,"Lac Malar","Suède",1140));
		repository.save(new Lake(2L,"Vänern","Suède",5650));
		repository.save(new Lake(3L,"Mjosa","Norvège",362));
		repository.save(new Lake(4L,"Storsjön","Suède",464));
		repository.save(new Lake(5L,"Femunden","Norvège",203.5f));
	}

}
