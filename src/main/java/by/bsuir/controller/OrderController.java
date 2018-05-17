package by.bsuir.controller;

import by.bsuir.service.interfaces.AccountService;
import by.bsuir.service.interfaces.OrderedProductService;
import by.bsuir.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderedProductService orderedProductService;

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/cabinet/addbasket", method = RequestMethod.POST)
    public String addBasket() {
        orderService.addBasket(AccountController.currentUserID);
        orderedProductService.clearUserBasket(AccountController.currentUserID);
        return "redirect:/cabinet";
    }

    @RequestMapping(value = "/moder", method = RequestMethod.GET)
    public String getAllOrders(Model model) {
        model.addAttribute("accounts", accountService.getAllAccounts());
        model.addAttribute("orders", orderService.getAllOrders());
        return "/moder";
    }

    @RequestMapping(value = "/moder/delete/{id}", method = RequestMethod.GET)
    public String deleteOrder(@PathVariable("id") int id) {
        orderService.deleteOrder(id);
        return "redirect:/moder";
    }

}
