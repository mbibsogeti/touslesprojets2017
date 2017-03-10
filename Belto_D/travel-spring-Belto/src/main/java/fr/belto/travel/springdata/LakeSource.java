package fr.belto.travel.springdata;

import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@EnableGemfireRepositories("fr.belto.travel.springdata")// package du depot
public class LakeSource {
// un objet repository de type LakeRepository
	private LakeRepository repository;
	public String getInfos(){
		 String LakesTot= "";
// aller chercher tous les dépots
	for (Lake l: repository.findAll()){
			LakesTot+=l.toString()+"/n"; // on aurait pu faire LakesTot=l
					}
// recuperer les grands lacs et les afficher
			LakesTot+="\n Grands lac:\n";
		for(Lake l:repository.findBySizeGreaterThan(1000)){
			LakesTot+=l+"\n";}
// ensuite les ranger par id
		LakesTot+="\n Grands lac ordonés:\n";
		for(Lake l:repository.findBySizeGreaterThanOrderById(1000)){
			LakesTot+=l+"\n";}
		return "\n"+ LakesTot;
	}
	public LakeRepository getRepository() {
		return repository;
	}
	public void setRepository(LakeRepository repository) {
		this.repository = repository;
	}
// remplir la base de donnée
	public void fillInfos(){
	   repository.save(new Lake(1l,"Lac Vanern","Suède",5648));
	   repository.save(new Lake(2l,"Lac Vattern","Suède",1912));
	   repository.save(new Lake(3l,"Lac Malar","Suède",1140));
	   repository.save(new Lake(4l,"Lac Siljan","Suède",354));
	   repository.save(new Lake(5l,"Lac mjosa","Norvège",362));
	   repository.save(new Lake(6l,"Lac Tyrifjord","Norvège",136));
	}
}
