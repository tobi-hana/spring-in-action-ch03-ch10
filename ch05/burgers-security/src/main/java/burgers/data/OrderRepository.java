package burgers.data;

import burgers.BurgerOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PostAuthorize;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<BurgerOrder, Long> {

}