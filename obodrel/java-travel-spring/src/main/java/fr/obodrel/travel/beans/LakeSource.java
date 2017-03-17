package fr.obodrel.travel.beans;

import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

import fr.obodrel.travel.interfaces.LakeRepository;

@EnableGemfireRepositories("fr.obodrel.travel.interfaces")
public class LakeSource {

	private LakeRepository _lakeRepository;

	public LakeRepository getRepository() {
		return _lakeRepository;
	}

	public void setRepository(LakeRepository lakeRepository) {
		_lakeRepository = lakeRepository;
	}

	public void fillInfos() {
		_lakeRepository.save(new Lake(1L, "Vanern Lake", "Sweden", 5648));
		_lakeRepository.save(new Lake(2L, "Glafsfjorden Lake", "Sweden", 102));
		_lakeRepository.save(new Lake(3L, "Storsjon Lake", "Sweden", 464));
		_lakeRepository.save(new Lake(4L, "Elkfjak Lake", "Sweden", 102));
	}

	public String getInfos() {
		String toRet = "All lakes :\n";
		for (Lake lake : _lakeRepository.findAll()) {
			toRet += lake + "\n";
		}

		toRet += "Big lakes :\n";
		for (Lake lake : _lakeRepository.findBySizeGreaterThan(250)) {
			toRet += lake + "\n";
		}
		toRet += "Big lakes order by id :\n";
		for (Lake lake : _lakeRepository.findBySizeGreaterThanOrderById(250)) {
			toRet += lake + "\n";
		}

		toRet += "Small lakes :\n";
		for (Lake lake : _lakeRepository.findBySizeLessThan(250)) {
			toRet += lake + "\n";
		}

		toRet += "Lake that are of size 464km² :\n";
		for (Lake lake : _lakeRepository.findBySizeEquals(464)) {
			toRet += lake + "\n";
		}

		toRet += "Lake that are of size 5648km² and named Vanern :\n";
		for (Lake lake : _lakeRepository.findBySizeAndNameEquals(5648, "Vanern Lake")) {
			toRet += lake + "\n";
		}

		toRet += "Lake that are of size 5648km² or named Glafsfjorden :\n";
		for (Lake lake : _lakeRepository.findBySizeOrNameEquals(5648, "Glafsfjorden Lake")) {
			toRet += lake + "\n";
		}

		toRet += "Lake that are of size 5648km² or named Glafsfjorden desc order of size :\n";
		for (Lake lake : _lakeRepository.findBySizeOrNameEqualsOrderBySizeDesc(5648, "Glafsfjorden Lake")) {
			toRet += lake + "\n";
		}

		toRet += "Lake that are of size 5648km² or named Glafsfjorden or from sweden asc order of size  asc order of id:\n";
		for (Lake lake : _lakeRepository.findBySizeOrNameOrCountryEqualsOrderBySizeAscIdAsc(5648, "Glafsfjorden Lake", "Sweden")) {
			toRet += lake + "\n";
		}

		toRet += "Lake that are of size 102km² and named finish by Lake :\n";
		for (Lake lake : _lakeRepository.findBySizeAndNameLike(102, "%Lake")) {
			toRet += lake + "\n";
		}

		toRet += "Lakes taht are after Sxoto (alphabetical order) :\n";
		for (Lake lake : _lakeRepository.findByNameGreaterThan("Sxoto")) {
			toRet += lake + "\n";
		}

		toRet += "Lake named Vanern = " + _lakeRepository.getByName("Vanern Lake")+"\n";

		return toRet;
	}
}
