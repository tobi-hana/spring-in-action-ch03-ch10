package burgers.data;

import burgers.BurgerOrder;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface OrderRepository extends CrudRepository<BurgerOrder, UUID> {

}