package fr.ib.spring.travel;

import org.springframework.data.repository.CrudRepository;

//Long en référence à l'id
public interface LakeRepository extends CrudRepository<Lake, Long> {
	
}