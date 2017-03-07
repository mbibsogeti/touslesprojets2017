package fr.belto.travel.springdata;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LakeRepository  extends CrudRepository<Lake,Long>{
// on demande de faire une fonction
List<Lake>findBySizeGreaterThan(float s);
List<Lake>findBySizeGreaterThanOrderById( float s);
//List<Lake>findBySizeLessThan(......);
//List<Lake>findBySizeBetween(......);
//List<Lake>findBySizelike(..... );
//List<Lake>findBySizeAnd(..... );
//List<Lake>findBySizeOr(..... );
}
