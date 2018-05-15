package by.bsuir.controller;

import by.bsuir.model.ReturnOrder;
import by.bsuir.service.interfaces.AccountService;
import by.bsuir.service.interfaces.ProductService;
import by.bsuir.service.interfaces.ReturnOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReturnOrderController {

    @Autowired
    private ReturnOrderService returnOrderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/return", method = RequestMethod.POST)
    public String addReturnOrder(@ModelAttribute("return") ReturnOrder returnOrder) {
        returnOrderService.addReturnOrder(AccountController.currentUserID, returnOrder.getProductID());
        return "return";
    }

    @RequestMapping(value = "/return/manage", method = RequestMethod.GET)
    public String getAllReturnOrders(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("accounts", accountService.getAllAccounts());
        model.addAttribute("returns", returnOrderService.getAllReturnOrders());
        return "return/manage";
    }

    @RequestMapping(value = "/return/{id}", method = RequestMethod.DELETE)
    public String deleteReturnOrder(@PathVariable("id") int id) {
        returnOrderService.deleteReturnOrder(id);
        return "redirect:/return";
    }

}
