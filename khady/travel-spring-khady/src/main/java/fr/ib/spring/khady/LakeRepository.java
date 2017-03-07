package fr.ib.spring.khady;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/* c'est l'équivalent de HibernateUtil.jave*/
public interface LakeRepository extends CrudRepository
    <Lake, Long> {
	List<Lake> findBySizeGreaterThan(float s);

	/* <Lake, Long>Lake = nom de la classe(l'entité) et Long = Id */
}
