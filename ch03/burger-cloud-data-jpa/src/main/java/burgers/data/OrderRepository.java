package burgers.data;

import org.springframework.data.repository.CrudRepository;
import burgers.BurgerOrder;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<BurgerOrder, Long> {
//    unnecessary examples from book
//    List<BurgerOrder> findByDeliveryZip(String deliveryZip);
//    List<BurgerOrder> readOrdersByDeliveryZipAndPlacedAtBetween(
//            String deliveryZip, Date startDate, Date endDate
//    );
////    find == read == get
}