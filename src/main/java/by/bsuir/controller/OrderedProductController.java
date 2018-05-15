package by.bsuir.controller;

import by.bsuir.service.interfaces.OrderedProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderedProductController {

    @Autowired
    private OrderedProductService orderedProductService;

    @RequestMapping(value = "/product/order/{type}/{id}", method = RequestMethod.GET)
    public String addProductToBasket(@PathVariable("id") int id, @PathVariable("type") String type) {
        orderedProductService.addProductInBasket(AccountController.currentUserID, id);
        return "redirect:/products/" + type;
    }

}
