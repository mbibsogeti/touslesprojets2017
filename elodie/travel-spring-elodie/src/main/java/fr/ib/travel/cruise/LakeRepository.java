package fr.ib.travel.cruise;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LakeRepository extends CrudRepository<Lake,Long>{
	List<Lake>findBySizeGreaterThan(float s);
	List<Lake>findFirstBySizeGreaterThanOrderBySizeAsc(float s);

}
