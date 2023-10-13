package burgers.data;

import burgers.BurgerOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<BurgerOrder, String> {

}