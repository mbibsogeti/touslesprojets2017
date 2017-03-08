package lake;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

// Cette interface sera complétée par Spring : on ne la touchera plus nous-mêmes.
public interface LakeRepository extends CrudRepository <Lake, Long>{
	List<Lake> findBySizeGreaterThan(float s);
	List<Lake> findBySizeGreaterThanOrderBySize(float s);
	List<Lake> findBySizeGreaterThanOrderByName(float s);
	List<Lake> findBySizeGreaterThanOrderByCountry(float s);
	List<Lake> findBySizeBetween(float min, float max);

}
