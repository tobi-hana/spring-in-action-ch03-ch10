package burgers.web;

import burgers.BurgerOrder;
import burgers.data.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.Date;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("burgerOrder")
public class OrderController {
    private OrderRepository orderRepository;
    public OrderController(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @PostMapping
    public String processOrder(@Valid BurgerOrder order,
                               Errors errors,
                               SessionStatus sessionStatus){
        if(errors.hasErrors()){
            return "orderForm";
        }

        order.setPlacedAt(new Date());
        orderRepository.save(order);
        log.info("Order submitted: {}", order);
        sessionStatus.setComplete();

        return "redirect:/";
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }
}