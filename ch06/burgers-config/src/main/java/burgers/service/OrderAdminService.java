package burgers.service;

import burgers.BurgerOrder;
import burgers.data.OrderRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class OrderAdminService {
    private OrderRepository orderRepository;

    public OrderAdminService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteAllOrders(){
        orderRepository.deleteAll();
    }

    @PostAuthorize("hasRole('ADMIN') || returnObject.user.username == authentication.name")
    public BurgerOrder getOrder(long id) {
        return orderRepository.findById(id).orElse(null);
    }


}
