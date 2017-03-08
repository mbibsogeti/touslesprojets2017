package jk.travel.scandinavie;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

// Cette interface va être automatiquement implémentée avec Spring
// CRUD : Create, Remove, Update, Display
public interface LakeRepository extends CrudRepository<Lake, Long> {
	List<Lake> findBySizeGreaterThanAndCountry(float s, String c);
} // end LakeRepository interface