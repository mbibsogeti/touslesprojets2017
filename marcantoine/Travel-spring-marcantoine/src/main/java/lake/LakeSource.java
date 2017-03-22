package lake;

import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

// NB : si on a une différence de package avec notre repository, il faut lui indiquer où ce dernier se trouve.
// va chercher l'interface et fabriquer classes qui correspondent
@EnableGemfireRepositories
public class LakeSource {

	private LakeRepository repository;

	public String getInfo() {
		String s = "";
		for (Lake l : repository.findAll()) {
			// L'appel à toString n'est pas obligatoire : le compilateur y faire
			// appel sans nécessité d'écriture en toutes lettres.
			s += (l.toString() + "\n");
		}
		s += "Lakes bigger than 1000sm: \n";
		for (Lake l1 : repository.findBySizeGreaterThan(4000)) {
			s += l1 + "\n";
		}
		return s;
	}

	// Ecrire dans notre dépôt
	public void fillInfo() {
		repository.save(new Lake(1L, 5648, "Varern Lake", "Sweden"));
		repository.save(new Lake(2L, 2800, "Boren", "Sweden"));
		repository.save(new Lake(3L, 13056, "Dellen", "Sweden"));
		repository.save(new Lake(4L, 6864, "Boren", "Sweden"));
		repository.save(new Lake(5L, 280498, "Votna", "Norway"));
		repository.save(new Lake(6L, 1564, "Ovre", "Norway"));
	}

	public LakeRepository getRepository() {
		return repository;
	}

	public void setRepository(LakeRepository repository) {
		this.repository = repository;
	}

}
