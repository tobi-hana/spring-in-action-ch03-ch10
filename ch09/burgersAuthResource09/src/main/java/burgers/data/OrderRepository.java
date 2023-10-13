package burgers.data;

import burgers.BurgerOrder;
import burgers.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<BurgerOrder, Long> {
    List<BurgerOrder> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}