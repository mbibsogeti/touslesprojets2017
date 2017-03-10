package jk.travel.scandinavie;

import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

// Fouille le package en argument, trouve l'interface LakeRepository et fabrique en interne la classe pour pouvoir l'implémenter 
@EnableGemfireRepositories("jk.travel.scandinavie")
public class LakeSource {

	// ATTRIBUTS //
	// Attribut d'interface
	private LakeRepository _repository;

	// MÉTHODES //
	public LakeRepository getRepository() {
		return _repository;
	}

	public void setRepository(LakeRepository repository) {
		_repository = repository;
	}

	public void fillInfos() {
		_repository.save(new Lake(1L, "Lac Vänern", "Suède", 5648));
		_repository.save(new Lake(2L, "Lac Mjøsa", "Norvège", 362));
		_repository.save(new Lake(3L, "Lac Päijänne", "Finlande", 1081));
		_repository.save(new Lake(4L, "Lac Oulujärvi", "Finlande", 887));
		_repository.save(new Lake(5L, "Lac Storsjön", "Suède", 464));
	} // end fillInfos method

	public String getInfos() {
		// 1 - Trouver un lac précis. Changer le type de retour à Lake
		// Lake premierLac = _repository.findOne(1L);

		// 2 - Afficher tous les lacs
		// String listeLac = "";
		// for (Lake i : _repository.findAll()) {
		// listeLac += i + "\n";
		// }
		// return listeLac;

		// 3 - Critères. Autres méthodes : LessThan, Between, Like..., And..., Or..., OrderBy...Asc, OrderBy...Desc
		
		String grandsLacs = "";
		for (Lake i : _repository.findBySizeGreaterThanAndCountry(1000, "Suède")) {
			grandsLacs += i + "\n";
		}
		return grandsLacs;
	} // end getInfos method
} // end LakeSource class