package by.bsuir.controller;

import by.bsuir.service.interfaces.AccountService;
import by.bsuir.service.interfaces.OrderedProductService;
import by.bsuir.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CabinetController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderedProductService orderedProductService;

    @RequestMapping(value = "/cabinet", method = RequestMethod.GET)
    public String openCabinet(Model model) {
        String role = accountService.getAccountById(AccountController.currentUserID).getRole();
        switch (role) {
            case "moder":
                return "redirect:/moder";
            case "admin":
                return "redirect:/account/all";
            case "user":
                model.addAttribute("account", accountService.getAccountById(AccountController.currentUserID));
                model.addAttribute("products", productService.getAllProducts());
                model.addAttribute("basket", orderedProductService.getAllOrderedProductsOfUser(AccountController.currentUserID));
                return "/cabinet";
            default:
                return "redirect:/auth";
        }

    }

    @RequestMapping(value = "/cabinet/delete/{id}", method = RequestMethod.GET)
    public String deleteProductFromBasket(@PathVariable("id") int id) {
        orderedProductService.deleteProductFromBasket(id);
        return "redirect:/cabinet";
    }

}
