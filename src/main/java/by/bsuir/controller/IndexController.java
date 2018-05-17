package by.bsuir.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String openIndex(Model model) {
        model.addAttribute("accountID", AccountController.currentUserID);
        return "/index";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String openAbout(Model model) {
        model.addAttribute("accountID", AccountController.currentUserID);
        return "/about";
    }

}
