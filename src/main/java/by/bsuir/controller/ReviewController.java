package by.bsuir.controller;

import by.bsuir.model.Review;
import by.bsuir.service.interfaces.AccountService;
import by.bsuir.service.interfaces.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReviewController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ReviewService reviewService;

    @RequestMapping(value = "/reviews", method = RequestMethod.GET)
    public String getAllReviews(Model model) {
        model.addAttribute("review", new Review());
        model.addAttribute("accounts", accountService.getAllAccounts());
        model.addAttribute("reviews", reviewService.getAllReviews());
        return "/reviews";
    }

    @RequestMapping(value = "/reviews/add", method = RequestMethod.POST)
    public String addReview(@ModelAttribute("review") Review review) {
        reviewService.addReview(AccountController.currentUserID, review);
        return "/reviews";
    }

}
