package fr.ib.travel;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LakeRepository extends CrudRepository<Lake, Long> {

	/*
	 * On défini les opérations possibles sur les objets du repository. Il
	 * suffit simplement de les écrire pour les définir. On peut ensuite les
	 * utiliser dans les classes du projets
	 */
	List<Lake> findBySizeGreaterThan(float s);// GreaterThan / LessThan /
												// Between / Like / And / Or /
												// OrderBy

}
