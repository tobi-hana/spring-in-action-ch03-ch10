package burgers.web;

import burgers.BurgerOrder;
import burgers.User;
import burgers.data.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;


//@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("burgerOrder")
//Config props are now in Order Props
//@ConfigurationProperties(prefix = "burger.orders")
public class OrderController {
    private OrderProps props;
    private OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository,
                           OrderProps props){
        this.orderRepository = orderRepository;
        this.props = props;
    }

    @PostMapping
    public String processOrder(@Valid BurgerOrder order,
                               Errors errors,
                               SessionStatus sessionStatus,
                               @AuthenticationPrincipal User user){
        if(errors.hasErrors()){
            return "orderForm";
        }
        order.setUser(user);

        orderRepository.save(order);
//        needs Sl4j annotation
//        log.info("Order submitted: {}", order);
        sessionStatus.setComplete();

        return "redirect:/";
    }

//    @GetMapping("/current")
//    public String orderForm() {
//        return "orderForm";
//    }

    @GetMapping("/current")
    public String orderForm(@AuthenticationPrincipal User user,
                            @ModelAttribute BurgerOrder order) {
        if (order.getDeliveryName() == null) {
            order.setDeliveryName(user.getFullname());
        }
        if (order.getDeliveryStreet() == null) {
            order.setDeliveryStreet(user.getStreet());
        }
        if (order.getDeliveryCity() == null) {
            order.setDeliveryCity(user.getCity());
        }

        return "orderForm";
    }

    @GetMapping
    public String showOrderList(@AuthenticationPrincipal User user,
                            Model model) {
        Pageable pageable = PageRequest.of(0, props.getPageSize());
        model.addAttribute("orders",
                orderRepository.findByUserOrderByPlacedAtDesc(user, pageable));
        return "orderList";
    }
}