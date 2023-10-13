package burgers.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import burgers.service.OrderAdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private OrderAdminService adminService;

    @Autowired
    public AdminController(OrderAdminService adminService){
        this.adminService = adminService;
    }
    @GetMapping
    public String adminForm(){
        return "adminForm";
    }
    @PostMapping("/deleteOrders")
    public String deleteAllOrders() {
        adminService.deleteAllOrders();
        return "redirect:/admin";
    }
}
