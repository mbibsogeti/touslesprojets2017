package fr.ib.hugo.travel.scandinavia;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//CrudRepository: équivalent d'une session dans hibernate. 
//CrudRepository est un type de dépôt interfacé qui permet d'agir 
//sur les éléments qu'il contient. Il doit donc être typé,
//ici avec le type d'élément (Lake) et le type de l'identifiant (long)
public interface LakeRepository extends CrudRepository<Lake, Long> {
	// assamblage d'une fonction par mot clés: finBy, GreaterThan, LessThan,
	// Between, Like, And, Or, OrderBy; et les noms de variables utilisés dans
	// le projet: name, country, id, size
	List<Lake> findBySizeGreaterThanOrderByIdAsc(float s);
	List<Lake> findBySizeLessThan(float s);
}
