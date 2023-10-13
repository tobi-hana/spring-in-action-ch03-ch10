package burgers.web.api;/*
 * with REST dependency in POM
 * there is no need in RestControllers
 * */
//package burgers.web.api;
//
//import burgers.BurgerOrder;
//import burgers.data.OrderRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping(path="api/orders",
//                produces={"application/json", "text/xml"})
//@CrossOrigin(origins={"http://burgercloud:8080", "http://burgercloud.com"})
//public class OrderRestController {
//    private OrderRepository orderRepository;
//    @Autowired
//    public OrderRestController(OrderRepository orderRepository){
//        this.orderRepository = orderRepository;
//    }
//    @PutMapping(path="/{orderId}", consumes = "application/json")
//    public BurgerOrder putOrder(@PathVariable("orderId") Long orderId,
//                                @RequestBody BurgerOrder order) {
//        order.setId(orderId);
//        return orderRepository.save(order);
//    }
//    @PatchMapping(path="/{orderId}", consumes="application/json")
//    public BurgerOrder patchOrder(@PathVariable("orderId") Long orderId,
//                                  @RequestBody BurgerOrder patchOrder) {
//        BurgerOrder order = orderRepository.findById(orderId).get();
//        if (patchOrder.getDeliveryName() != null) {
//            order.setDeliveryName(patchOrder.getDeliveryName());
//        }
//        if(patchOrder.getDeliveryStreet() != null){
//            order.setDeliveryStreet(patchOrder.getDeliveryStreet());
//        }
//        if (patchOrder.getDeliveryCity() != null) {
//            order.setDeliveryCity(patchOrder.getDeliveryCity());
//        }
//        if (patchOrder.getDeliveryZip() != null) {
//            order.setDeliveryZip(patchOrder.getDeliveryZip());
//        }
//        if (patchOrder.getCcNumber() != null) {
//            order.setCcNumber(patchOrder.getCcNumber());
//        }
//        if (patchOrder.getCcExpiration() != null) {
//            order.setCcExpiration(patchOrder.getCcExpiration());
//        }
//        if (patchOrder.getCcCVV() != null) {
//            order.setCcCVV(patchOrder.getCcCVV());
//        }
//        return orderRepository.save(order);
//    }
//    @DeleteMapping("/{orderId}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteOrder(@PathVariable("orderId") Long orderId) {
//        try {
//            orderRepository.deleteById(orderId);
//        } catch (EmptyResultDataAccessException e) {}
//    }
//
//}
