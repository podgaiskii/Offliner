package by.bsuir.controller;

import by.bsuir.model.Account;
import by.bsuir.service.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    public static int currentUserID = -1;

    public int getCurrentUserID() {
        return currentUserID;
    }

    @RequestMapping(value = "/account/all", method = RequestMethod.GET)
    public String getAllAccounts(Model model) {
        model.addAttribute("account", new Account());
        model.addAttribute("accounts", accountService.getAllAccounts());
        return "/accounts";
    }

    @RequestMapping(value = "/account/add", method = RequestMethod.GET)
    public String addAccount(@ModelAttribute("account") Account account) {
        if (account.getId() == 0) {
            accountService.addAccount(account);
        } else {
            accountService.updateAccount(account);
        }
        return "redirect:/users";
    }

    @RequestMapping(value = "/account/delete/{id}", method = RequestMethod.GET)
    public String deleteAccount(@PathVariable("id") int id) {
        if (id != 0) {
            accountService.deleteAccount(id);
        }
        return "redirect:/account";
    }

    @RequestMapping(value = "/account/edit/{id}", method = RequestMethod.GET)
    public String editAccount(@PathVariable("id") int id, Model model) {
        model.addAttribute("account", accountService.getAccountById(id));
        model.addAttribute("accounts", accountService.getAllAccounts());
        return "redirect:/account";
    }

    @RequestMapping(value = "/account/get/{id}", method = RequestMethod.GET)
    public String showAccount(@PathVariable("id") int id, Model model) {
        model.addAttribute("account", accountService.getAccountById(id));
        return "redirect:/account";
    }

}
