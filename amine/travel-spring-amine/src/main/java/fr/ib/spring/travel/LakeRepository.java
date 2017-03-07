package fr.ib.spring.travel;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//Long en référence à l'id
public interface LakeRepository extends CrudRepository<Lake, Long> {
	List<Lake>findBySizeGreaterThan(float s);
}