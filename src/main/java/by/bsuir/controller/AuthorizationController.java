package by.bsuir.controller;

import by.bsuir.model.Account;
import by.bsuir.service.AccountServiceImpl;
import by.bsuir.service.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthorizationController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public String authorize(Model model) {
        if (AccountController.currentUserID != -1) {
            return "redirect:/cabinet";
        }
        model.addAttribute("account", new Account());
        return "auth";
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public String authorizeAccount(@ModelAttribute("account") Account account) {
        account = accountService.authorizeAccount(account);
        AccountController.currentUserID = account.getId();
        switch (account.getRole()) {
            case "user":
                return "redirect:/cabinet";
            case "moder":
                return "redirect:/manager";
            case "account":
                return "redirect:/account";
            default:
                return "redirect:/auth";
        }
    }

}
