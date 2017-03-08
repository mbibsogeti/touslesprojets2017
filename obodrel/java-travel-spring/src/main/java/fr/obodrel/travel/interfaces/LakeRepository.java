package fr.obodrel.travel.interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.obodrel.travel.beans.Lake;

public interface LakeRepository extends CrudRepository<Lake, Long> {
	public List<Lake> findBySizeGreaterThan(float size);
	public List<Lake> findBySizeGreaterThanOrderById(float size);
	public List<Lake> findBySizeLessThan(float size);
	public List<Lake> findBySizeEquals(float size);
	public List<Lake> findBySizeAndNameEquals(float size, String name);
	public List<Lake> findBySizeOrNameEquals(float size, String name);
	public List<Lake> findBySizeOrNameEqualsOrderBySizeDesc(float size, String name);
	public List<Lake> findBySizeOrNameOrCountryEqualsOrderBySizeAscIdAsc(float size, String name, String Country);
	public List<Lake> findBySizeAndNameLike(float size, String name);
	public List<Lake> findByNameGreaterThan(String name);
	public Lake getByName(String name);
}
