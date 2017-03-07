package main;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import lake.Lake;

public interface LakeRepository extends CrudRepository<Lake, Long> {

	List<Lake> findBySizeGreaterThan(float s);
	List<Lake> findBySizeGreaterThanOrderByIdDesc(float s);
	List<Lake> findBySizeGreaterThanOrderByIdAsc(float s);
	List<Lake> findBySizeGreaterThanOrderByNameDesc(float s);
	List<Lake> findBySizeGreaterThanOrderByNameAsc(float s);
}
