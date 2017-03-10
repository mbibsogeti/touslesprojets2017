package travel;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LakeRepository extends CrudRepository<Lake, Long> {
	
	List<Lake>findBySizeGreaterThanOrderByName(float s);  //commande de 'linterface ui peu etre appeler par le main.

}
